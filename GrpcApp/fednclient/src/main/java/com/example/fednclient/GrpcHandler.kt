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


interface IGrpcHandler {
    suspend fun sendHeartbeat()
    suspend fun listenToModelUpdateRequestStream()
}

class GrpcHandler(
    private val name: String,
    private val url: String,
    private val port: Int,
    private val token: String,
) : IGrpcHandler, Closeable {

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

//        println("sending Heartbeat...")

        try {

            val request: Heartbeat = Heartbeat.newBuilder().setSender(
                Client.newBuilder().setName(name).setRole(
                    Role.WORKER
                ).build()
            ).build()

            val headers = Metadata().apply {
                val key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER)
                put(key, "Token $token")
            }

            connectorStub.sendHeartbeat(request, headers)
        } catch (e: Exception) {
//            println("Error: ${e.message}")
        }
    }

    override suspend fun listenToModelUpdateRequestStream() {

        println("initialize listener for model update requests...")

        val clientAvailableMessage: ClientAvailableMessage =
            ClientAvailableMessage.newBuilder().setSender(
                Client.newBuilder().setName(name).setRole(Role.WORKER).build()
            ).build()

        val stream = combinerStub.modelUpdateRequestStream(clientAvailableMessage)

        stream.collect { value ->

            if (value.sender.role == Role.COMBINER) {

                processTrainingRequest(value)
            }
        }
    }

    private suspend fun processTrainingRequest(value: ModelUpdateRequest) {

        val model: ByteString? = getModel(value)

        val uuid = UUID.randomUUID()
        val uuidStr = uuid.toString()

        val flow: Flow<ModelRequest> = flow {

            val byteString: ByteString? = model

            if (byteString != null) {

                val arr: List<ByteString> = splitByteStringIntoChunks(byteString, 1024 * 1024)


                for (chunk in arr) {

                    val modelRequest: ModelRequest =
                        ModelRequest.newBuilder().setData(chunk).setId(uuidStr)
                            .setStatus(ModelStatus.IN_PROGRESS)
                            .build()
                    emit(modelRequest)
                }

                val modelRequest: ModelRequest =
                    ModelRequest.newBuilder().setId(uuidStr)
                        .setStatus(ModelStatus.OK)
                        .build()
                emit(modelRequest)
            }
        }

        try {

            val result = modelServiceStub.upload(flow)

            println("Upload response: ${result.message}")

        } catch (e: io.grpc.StatusException) {

            println(e)
        }

        sendModelUpdate(uuidStr, value)
    }

    private suspend fun sendModelUpdate(updatedModelId: String, value: ModelUpdateRequest) {

        val modelUpdate: ModelUpdate =
            ModelUpdate.newBuilder().setSender(
                Client.newBuilder().setName(
                    name
                ).setRole(Role.WORKER)
            ).setReceiver(
                Client.newBuilder().setName(value.sender.name).setRole(value.sender.role)
            ).setModelId(value.modelId).setModelUpdateId(updatedModelId)
                .setTimestamp(getCurrentTimestamp()).setCorrelationId(value.correlationId)
                .setMeta("").build()

        val response = combinerStub.sendModelUpdate(modelUpdate)

        println("model update response: $response")
    }

    private suspend fun getModel(value: ModelUpdateRequest): ByteString? {

        val request: ModelRequest = ModelRequest.newBuilder().setId(value.modelId).build()
        val stream = modelServiceStub.download(request)

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