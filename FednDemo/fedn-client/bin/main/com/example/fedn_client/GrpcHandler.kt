package com.example.fedn_client

import com.example.fedn_client.grpc.Client
import com.example.fedn_client.grpc.ClientAvailableMessage
import com.example.fedn_client.grpc.CombinerGrpcKt
import com.example.fedn_client.grpc.ConnectorGrpcKt
import com.example.fedn_client.grpc.Heartbeat
import com.example.fedn_client.grpc.ModelRequest
import com.example.fedn_client.grpc.ModelServiceGrpcKt
import com.example.fedn_client.grpc.ModelStatus
import com.example.fedn_client.grpc.ModelUpdate
import com.example.fedn_client.grpc.ModelUpdateRequest
import com.example.fedn_client.grpc.Role
import com.google.protobuf.ByteString
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import io.grpc.NameResolver
import io.grpc.StatusException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import java.io.Closeable
import java.util.UUID

const val CHUNK_SIZE: Int = 1024 * 1024

enum class ModelUpdateState {
    LISTENER_INITIALIZED, SERVER_MODEL_DOWNLOADED, TRAINING_STARTED, TRAINING_COMPLETED, MODEL_UPLOADED, TRAINING_ROUND_FINISHED
}
interface IGrpcHandler : Closeable {
    suspend fun sendHeartbeat()
    suspend fun listenToModelUpdateRequestStream(
        trainModel: (ByteArray) -> ByteArray,
        onStateChanged: ((state: ModelUpdateState) -> Unit)? = null,
        onStateChangedInternal: (state: ModelUpdateState) -> Unit
    )
}

internal class GrpcHandler(
    private val name: String,
    private val url: String,
    private val port: Int,
    private val token: String,
    private val combinerName: String
) : IGrpcHandler {

    private val headers = Metadata().apply {
        val key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER)
        put(key, "Token $token")
        val clientNameKey = Metadata.Key.of("client", Metadata.ASCII_STRING_MARSHALLER)
        put(clientNameKey, name)
        val contentTypeKey = Metadata.Key.of("Grpc-Server", Metadata.ASCII_STRING_MARSHALLER)
        put(contentTypeKey, combinerName)
    }

    private var _managedChannel: ManagedChannel? = null
    private val managedChannel: ManagedChannel
        get() {

            if (_managedChannel == null) {

                _managedChannel =
                    ManagedChannelBuilder.forAddress(url, port).useTransportSecurity().build()
            }

            return _managedChannel ?: throw AssertionError("Set to null by another thread")
        }

    private val connectorStub: ConnectorGrpcKt.ConnectorCoroutineStub =
        ConnectorGrpcKt.ConnectorCoroutineStub(managedChannel)

    private val combinerStub: CombinerGrpcKt.CombinerCoroutineStub =
        CombinerGrpcKt.CombinerCoroutineStub(managedChannel)

    private val modelServiceStub: ModelServiceGrpcKt.ModelServiceCoroutineStub =
        ModelServiceGrpcKt.ModelServiceCoroutineStub(managedChannel)

    override suspend fun sendHeartbeat() {

        println("sending Heartbeat...")

        try {

            val request: Heartbeat = Heartbeat.newBuilder().setSender(
                Client.newBuilder().setName(name).setRole(
                    Role.WORKER
                ).build()
            ).build()

            connectorStub.sendHeartbeat(request, headers)
        } catch (e: StatusException) {
            println("StatusException: ${e.message}")
        } catch (e: Exception) {
            println("Exception: ${e.message}")
        }
    }

    override suspend fun listenToModelUpdateRequestStream(
        trainModel: (modelIn: ByteArray) -> ByteArray,
        onStateChanged: ((state: ModelUpdateState) -> Unit)?,
        onStateChangedInternal: (state: ModelUpdateState) -> Unit
    ) {

        println("initialize listener for model update requests...")

        val clientAvailableMessage: ClientAvailableMessage =
            ClientAvailableMessage.newBuilder().setSender(
                Client.newBuilder().setName(name).setRole(Role.WORKER).build()
            ).build()

        val stream = combinerStub.modelUpdateRequestStream(clientAvailableMessage, headers)

        try {
            onStateChanged?.invoke(ModelUpdateState.LISTENER_INITIALIZED)
            onStateChangedInternal.invoke(ModelUpdateState.LISTENER_INITIALIZED)

            stream.collect { value ->

                if (value.sender.role == Role.COMBINER) {

                    processTrainingRequest(
                        value,
                        trainModel,
                        onStateChanged,
                        onStateChangedInternal
                    )
                }
            }
        } catch (e: StatusException) {
            println("StatusException: ${e.message}")
        } catch (e: Exception) {
            println("Exception: ${e.message}")
        }
    }

    private suspend fun processTrainingRequest(
        value: ModelUpdateRequest,
        trainModel: (ByteArray) -> ByteArray,
        onStateChanged: ((state: ModelUpdateState) -> Unit)?,
        onStateChangedInternal: (state: ModelUpdateState) -> Unit
    ) {

        val serveModelByteArray: ByteArray? = getServerModel(value)

        onStateChanged?.invoke(ModelUpdateState.SERVER_MODEL_DOWNLOADED)
        onStateChangedInternal.invoke(ModelUpdateState.SERVER_MODEL_DOWNLOADED)

        if (serveModelByteArray != null) {

            onStateChanged?.invoke(ModelUpdateState.TRAINING_STARTED)
            onStateChangedInternal.invoke(ModelUpdateState.TRAINING_STARTED)

            try {

                val trainedModelByteArray: ByteArray = trainModel(serveModelByteArray)
                val trainedModel: ByteString? = ByteString.copyFrom(trainedModelByteArray)

                onStateChanged?.invoke(ModelUpdateState.TRAINING_COMPLETED)
                onStateChangedInternal.invoke(ModelUpdateState.TRAINING_COMPLETED)

                val uuid = UUID.randomUUID()
                val uuidStr = uuid.toString()

                val flow: Flow<ModelRequest> = flow {

                    if (trainedModel != null) {

                        val arr: List<ByteString> =
                            splitByteStringIntoChunks(trainedModel, CHUNK_SIZE)

                        for (chunk in arr) {

                            val modelRequest: ModelRequest =
                                ModelRequest.newBuilder().setData(chunk).setId(uuidStr)
                                    .setStatus(ModelStatus.IN_PROGRESS).build()

                            emit(modelRequest)
                        }

                    } else {

                        println("Training resulted in null")
                    }

                    val modelRequest: ModelRequest =
                        ModelRequest.newBuilder().setId(uuidStr).setStatus(ModelStatus.OK).build()

                    emit(modelRequest)
                }

                val result = modelServiceStub.upload(flow, headers)
                println("Upload response: ${result.message}")

                sendModelUpdate(uuidStr, value, onStateChanged, onStateChangedInternal)
            } catch (e: StatusException) {
                println("StatusException: ${e.message}")
            } catch (e: Exception) {
                println("Exception: ${e.message}")
            }
        }

        onStateChanged?.invoke(ModelUpdateState.TRAINING_ROUND_FINISHED)
        onStateChangedInternal.invoke(ModelUpdateState.TRAINING_ROUND_FINISHED)
    }

    private suspend fun sendModelUpdate(
        updatedModelId: String,
        value: ModelUpdateRequest,
        onStateChanged: ((state: ModelUpdateState) -> Unit)?,
        onStateChangedInternal: (state: ModelUpdateState) -> Unit
    ) {

        println(value)

        val metadataJson = buildJsonObject {
            put("num_examples", 1)
            put("batch_size", 1)
            put("epochs", 1)
            put("lr", 1)
        }
        val configJson = buildJsonObject {
            put("round_id", 1)
        }

        val json = buildJsonObject {
            put("training_metadata", metadataJson)
            put("config", configJson.toString())
        }

        try {
            val modelUpdate: ModelUpdate = ModelUpdate.newBuilder().setSender(
                Client.newBuilder().setName(
                    name
                ).setRole(Role.WORKER)
            ).setReceiver(
                Client.newBuilder().setName(value.sender.name).setRole(value.sender.role)
            ).setModelId(value.modelId).setModelUpdateId(updatedModelId)
                .setTimestamp(getCurrentTimestamp()).setCorrelationId(value.correlationId)
                .setMeta(json.toString())
                .build()

            val response = combinerStub.sendModelUpdate(modelUpdate, headers)

            onStateChanged?.invoke(ModelUpdateState.MODEL_UPLOADED)
            onStateChangedInternal.invoke(ModelUpdateState.MODEL_UPLOADED)

            println("model update response: $response")
        } catch (e: StatusException) {
            println("StatusException: ${e.message}")
        } catch (e: Exception) {
            println("Exception: ${e.message}")
        }
    }

    private suspend fun getServerModel(value: ModelUpdateRequest): ByteArray? {
        var result: ByteArray? = null

        try {
            val request: ModelRequest = ModelRequest.newBuilder().setId(value.modelId).build()
            val stream = modelServiceStub.download(request, headers)

            stream.collect { s ->

                if (s.status == ModelStatus.IN_PROGRESS || s.status == ModelStatus.OK) {

                    result = if (result == null) {

                        s.data.toByteArray()
                    } else {

                        result!! + s.data.toByteArray()
                    }
                }
            }
        } catch (e: StatusException) {
            println("StatusException: ${e.message}")
        } catch (e: Exception) {
            println("Exception: ${e.message}")
        }

        return result
    }


    override fun close() {

        managedChannel.shutdown()
    }
}