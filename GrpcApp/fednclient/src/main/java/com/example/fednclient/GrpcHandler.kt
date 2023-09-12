package com.example.fednclient

import com.example.fednclient.grpc.Client
import com.example.fednclient.grpc.ClientAvailableMessage
import com.example.fednclient.grpc.CombinerGrpcKt
import com.example.fednclient.grpc.ConnectorGrpcKt
import com.example.fednclient.grpc.Heartbeat
import com.example.fednclient.grpc.ModelRequest
import com.example.fednclient.grpc.ModelServiceGrpcKt
import com.example.fednclient.grpc.ModelStatus
import com.example.fednclient.grpc.ModelUpdate
import com.example.fednclient.grpc.ModelUpdateRequest
import com.example.fednclient.grpc.Role
import com.google.protobuf.ByteString
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.Closeable
import java.util.UUID

const val CHUNK_SIZE: Int = 1024 * 1024

enum class ModelUpdateState {
    LISTENER_INITIALIZED, SERVER_MODEL_DOWNLOADED, TRAINING_COMPLETED, MODEL_UPLOADED
}

interface IGrpcHandler {
    suspend fun sendHeartbeat()
    suspend fun listenToModelUpdateRequestStream(
        trainModel: (ByteArray) -> ByteArray,
        onStateChanged: ((state: ModelUpdateState) -> Unit)? = null
    )
}

internal class GrpcHandler(
    private val name: String,
    private val url: String,
    private val port: Int,
    private val token: String,
) : IGrpcHandler, Closeable {

    private val headers = Metadata().apply {
        val key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER)
        put(key, "Token $token")
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
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    override suspend fun listenToModelUpdateRequestStream(
        trainModel: (modelIn: ByteArray) -> ByteArray,
        onStateChanged: ((state: ModelUpdateState) -> Unit)?
    ) {

        println("initialize listener for model update requests...")

        val clientAvailableMessage: ClientAvailableMessage =
            ClientAvailableMessage.newBuilder().setSender(
                Client.newBuilder().setName(name).setRole(Role.WORKER).build()
            ).build()

        val stream = combinerStub.modelUpdateRequestStream(clientAvailableMessage, headers)

        onStateChanged?.invoke(ModelUpdateState.LISTENER_INITIALIZED)

        stream.collect { value ->

            if (value.sender.role == Role.COMBINER) {

                processTrainingRequest(value, trainModel, onStateChanged)
            }
        }
    }

    private suspend fun processTrainingRequest(
        value: ModelUpdateRequest,
        trainModel: (ByteArray) -> ByteArray,
        onStateChanged: ((state: ModelUpdateState) -> Unit)?
    ) {

        val serverModel: ByteString? = getServerModel(value)

        onStateChanged?.invoke(ModelUpdateState.SERVER_MODEL_DOWNLOADED)

        if (serverModel != null) {

            val serveModelByteArray: ByteArray = serverModel.toByteArray()
            val trainedModelByteArray: ByteArray = trainModel(serveModelByteArray)
            val trainedModel: ByteString? = ByteString.copyFrom(trainedModelByteArray)

            onStateChanged?.invoke(ModelUpdateState.TRAINING_COMPLETED)

            val uuid = UUID.randomUUID()
            val uuidStr = uuid.toString()

            val flow: Flow<ModelRequest> = flow {

                if (trainedModel != null) {

                    val arr: List<ByteString> = splitByteStringIntoChunks(trainedModel, CHUNK_SIZE)

                    for (chunk in arr) {

                        val modelRequest: ModelRequest =
                            ModelRequest.newBuilder().setData(chunk).setId(uuidStr)
                                .setStatus(ModelStatus.IN_PROGRESS).build()
                        emit(modelRequest)
                    }

                    val modelRequest: ModelRequest =
                        ModelRequest.newBuilder().setId(uuidStr).setStatus(ModelStatus.OK).build()
                    emit(modelRequest)
                } else {

                    println("Training resulted in null")
                }
            }

            try {

                val result = modelServiceStub.upload(flow, headers)

                println("Upload response: ${result.message}")

            } catch (e: io.grpc.StatusException) {

                println(e)
            }

            sendModelUpdate(uuidStr, value, onStateChanged)
        }
    }

    private suspend fun sendModelUpdate(
        updatedModelId: String,
        value: ModelUpdateRequest,
        onStateChanged: ((state: ModelUpdateState) -> Unit)?
    ) {

        val modelUpdate: ModelUpdate = ModelUpdate.newBuilder().setSender(
            Client.newBuilder().setName(
                name
            ).setRole(Role.WORKER)
        ).setReceiver(
            Client.newBuilder().setName(value.sender.name).setRole(value.sender.role)
        ).setModelId(value.modelId).setModelUpdateId(updatedModelId)
            .setTimestamp(getCurrentTimestamp()).setCorrelationId(value.correlationId).setMeta("")
            .build()

        val response = combinerStub.sendModelUpdate(modelUpdate, headers)

        onStateChanged?.invoke(ModelUpdateState.MODEL_UPLOADED)

        println("model update response: $response")
    }

    private suspend fun getServerModel(value: ModelUpdateRequest): ByteString? {

        val request: ModelRequest = ModelRequest.newBuilder().setId(value.modelId).build()
        val stream = modelServiceStub.download(request, headers)

        var result: ByteString? = null

        stream.collect { s ->

            if (s.status == ModelStatus.IN_PROGRESS || s.status == ModelStatus.OK) {

                if (result == null) {

                    result = s.data
                } else {

                    result!!.concat(s.data)
                }
            }
        }

        return result
    }


    override fun close() {

        managedChannel.shutdown()
    }
}