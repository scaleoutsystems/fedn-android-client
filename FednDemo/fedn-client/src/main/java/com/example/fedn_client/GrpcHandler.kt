package com.example.fedn_client


import PerformanceMonitor
import com.google.protobuf.ByteString
import fedn.CombinerGrpcKt
import fedn.ConnectorGrpcKt
import fedn.Fedn
import fedn.Fedn.TaskRequest
import fedn.ModelServiceGrpcKt
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
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
    suspend fun listenToTaskStream(
        trainModel: (ByteArray) -> ByteArray,
        onStateChanged: ((state: ModelUpdateState) -> Unit)? = null,
        onStateChangedInternal: (state: ModelUpdateState) -> Unit,
        onPerformanceResultMeasured: ((executionDuration: Long, modelId: String) -> Unit)? = null
    )
}

internal class GrpcHandler(
    private val name: String,
    private val id: String,
    private val url: String,
    private val port: Int,
    private val token: String,
    private val combinerName: String,
    private val secureGrpcConnection: Boolean = true
) : IGrpcHandler {

    private val headers = Metadata().apply {
        val key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER)
        put(key, "Bearer $token")
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
                    if (secureGrpcConnection)
                        ManagedChannelBuilder.forAddress(url, port).useTransportSecurity().build()
                    else
                        ManagedChannelBuilder.forAddress(url, port).usePlaintext().build()
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

            val request: Fedn.Heartbeat = Fedn.Heartbeat.newBuilder().setSender(
                Fedn.Client.newBuilder().setName(name).setRole(
                    Fedn.Role.CLIENT
                ).setClientId(id).build()
            ).build()

            connectorStub.sendHeartbeat(request, headers)
        } catch (e: StatusException) {
            println("StatusException: ${e.message}")
        } catch (e: Exception) {
            println("Exception: ${e.message}")
        }
    }

    override suspend fun listenToTaskStream(
        trainModel: (modelIn: ByteArray) -> ByteArray,
        onStateChanged: ((state: ModelUpdateState) -> Unit)?,
        onStateChangedInternal: (state: ModelUpdateState) -> Unit,
        onPerformanceResultMeasured: ((executionDuration: Long, modelId: String) -> Unit)?
    ) {

        println("initialize listener for task requests...")

        val clientAvailableMessage: Fedn.ClientAvailableMessage =
            Fedn.ClientAvailableMessage.newBuilder().setSender(
                Fedn.Client.newBuilder().setName(name).setRole(Fedn.Role.CLIENT).setClientId(id)
                    .build()
            ).build()

        val stream = combinerStub.taskStream(clientAvailableMessage, headers)

        try {
            onStateChanged?.invoke(ModelUpdateState.LISTENER_INITIALIZED)
            onStateChangedInternal.invoke(ModelUpdateState.LISTENER_INITIALIZED)

            stream.collect { value ->

                if (value.sender.role == Fedn.Role.COMBINER && value.type == Fedn.StatusType.MODEL_UPDATE) {

                    val performanceMonitor = PerformanceMonitor()

                    val executionDuration = performanceMonitor.measurePerformance {

                        processTrainingRequest(
                            value,
                            trainModel,
                            onStateChanged,
                            onStateChangedInternal
                        )
                    }

                    onPerformanceResultMeasured?.invoke(executionDuration, value.modelId)
                }
            }
        } catch (e: StatusException) {
            println("StatusException: ${e.message}")
        } catch (e: Exception) {
            println("Exception: ${e.message}")
        }
    }

    private suspend fun processTrainingRequest(
        value: TaskRequest,
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

                val flow: Flow<Fedn.ModelRequest> = flow {

                    if (trainedModel != null) {

                        val arr: List<ByteString> =
                            splitByteStringIntoChunks(trainedModel, CHUNK_SIZE)

                        for (chunk in arr) {

                            val modelRequest: Fedn.ModelRequest =
                                Fedn.ModelRequest.newBuilder().setData(chunk).setId(uuidStr)
                                    .setStatus(Fedn.ModelStatus.IN_PROGRESS).build()

                            emit(modelRequest)
                        }

                    } else {

                        println("Training resulted in null")
                    }

                    val modelRequest: Fedn.ModelRequest =
                        Fedn.ModelRequest.newBuilder().setId(uuidStr).setStatus(Fedn.ModelStatus.OK)
                            .build()

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
        value: TaskRequest,
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
            val modelUpdate: Fedn.ModelUpdate = Fedn.ModelUpdate.newBuilder().setSender(
                Fedn.Client.newBuilder().setName(
                    name
                ).setRole(Fedn.Role.CLIENT)
            ).setReceiver(
                Fedn.Client.newBuilder().setName(value.sender.name).setRole(value.sender.role)
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

    private suspend fun getServerModel(value: TaskRequest): ByteArray? {
        var result: ByteArray? = null

        try {
            val request: Fedn.ModelRequest =
                Fedn.ModelRequest.newBuilder().setId(value.modelId).build()
            val stream = modelServiceStub.download(request, headers)

            stream.collect { s ->

                if (s.status == Fedn.ModelStatus.IN_PROGRESS || s.status == Fedn.ModelStatus.OK) {

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