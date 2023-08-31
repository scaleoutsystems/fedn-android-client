package com.example.fednclient

import android.content.Context
import android.graphics.ColorSpace.Model
import androidx.core.content.ContentProviderCompat.requireContext
import java.util.UUID;
import com.example.fednclient.grpc.Client
import com.example.fednclient.grpc.ClientAvailableMessage
import com.example.fednclient.grpc.CombinerGrpcKt
import com.example.fednclient.grpc.ConnectorGrpcKt
import com.example.fednclient.grpc.Heartbeat
import com.example.fednclient.grpc.ModelRequest
import com.example.fednclient.grpc.ModelResponse
import com.example.fednclient.grpc.ModelServiceGrpcKt
import com.example.fednclient.grpc.ModelStatus
import com.example.fednclient.grpc.ModelUpdate
import com.example.fednclient.grpc.ModelUpdateRequest
import com.example.fednclient.grpc.Role
import com.google.protobuf.ByteString
import com.google.protobuf.kotlin.toByteStringUtf8
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.Closeable
import java.io.File
import java.io.FileInputStream
import java.security.AccessController.getContext
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date


interface IGrpcHandler {
    suspend fun sendHeartbeat()
    suspend fun listenToModelUpdateRequestStream()
}

class GrpcHandler(
    private val context: Context,
    private val name: String,
    private val url: String,
    private val port: Int,
    private val token: String,
) : IGrpcHandler, Closeable {

    private var _managedChannel: ManagedChannel? = null

    private val managedChannel: ManagedChannel
        get() {

            if (_managedChannel == null) {

                println("Setting managed channel | url: $url, port: $port")


                _managedChannel =
                    ManagedChannelBuilder.forAddress(url, port).useTransportSecurity().build()
            }

            return _managedChannel ?: throw AssertionError("Set to null by another thread")
        }

    private val connectorStub: ConnectorGrpcKt.ConnectorCoroutineStub =
        ConnectorGrpcKt.ConnectorCoroutineStub(managedChannel)

    private val combinerStub: CombinerGrpcKt.CombinerCoroutineStub =
        CombinerGrpcKt.CombinerCoroutineStub(managedChannel)

    val modelServiceStub: ModelServiceGrpcKt.ModelServiceCoroutineStub =
        ModelServiceGrpcKt.ModelServiceCoroutineStub(managedChannel)

    override suspend fun sendHeartbeat() {

        println("SendHeartBeat!!!")

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
            println("Error: ${e.message}")
        }
    }

    override suspend fun listenToModelUpdateRequestStream() {

        println("listenToModelUpdateRequestStream")

        val clientAvailableMessage: ClientAvailableMessage =
            ClientAvailableMessage.newBuilder().setSender(
                Client.newBuilder().setName(name).setRole(Role.WORKER).build()
            ).build()

        val stream = combinerStub.modelUpdateRequestStream(clientAvailableMessage)

        stream.collect { value ->
            println("I am in stream!")

            if (value.sender.role == Role.COMBINER) {

                println("Is combiner, yeah man!!!")

                processTrainingRequest(value)
            }
        }

        println("end of method!")
    }

    private suspend fun readSeedFileToByteString(): ByteString? {

        return try {
            val fileInputStream = context.openFileInput("seed.npz")
            val fileBytes = fileInputStream.readBytes()
            fileInputStream.close()

            ByteString.copyFrom(fileBytes)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }


    private fun splitByteStringIntoChunks(
        byteString: ByteString,
        chunkSize: Int
    ): List<ByteString> {
        val chunks = mutableListOf<ByteString>()
        var currentIndex = 0

        while (currentIndex < byteString.size()) {
            val endIndex = (currentIndex + chunkSize).coerceAtMost(byteString.size())
            val chunk = byteString.substring(currentIndex, endIndex)
            chunks.add(chunk)
            currentIndex = endIndex
        }

        return chunks
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

            println(result.message)

        } catch (e: io.grpc.StatusException) {

            println(e)
        }


        sendModelUpdate(uuidStr, value)
    }


    fun getCurrentTimestamp(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val currentDate = Date()
        return dateFormat.format(currentDate)
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

        println("response: $response")
    }

    private suspend fun getModel(value: ModelUpdateRequest): ByteString? {

        val request: ModelRequest = ModelRequest.newBuilder().setId(value.modelId).build()
        val stream = modelServiceStub.download(request)

        var result: ByteString? = null

        stream.collect { s ->

            val status: ModelStatus = s.status

            when (status) {
                ModelStatus.IN_PROGRESS -> {

                    if (result == null) {

                        result = s.data
                    } else {

                        result!!.concat(s.data)
                    }
                }

                ModelStatus.OK -> {

                    if (result == null) {

                        result = s.data
                    } else {

                        result!!.concat(s.data)
                    }
                }

                else -> {

                    println("getModel Failed")
                }
            }
        }

        println("getModel done!")
        return result
    }


    override fun close() {

        managedChannel.shutdown()
    }
}