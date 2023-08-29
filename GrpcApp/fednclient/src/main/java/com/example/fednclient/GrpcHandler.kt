package com.example.fednclient

import com.example.fednclient.grpc.Client
import com.example.fednclient.grpc.CombinerGrpcKt
import com.example.fednclient.grpc.ConnectorGrpc
import com.example.fednclient.grpc.ConnectorGrpc.ConnectorStub
import com.example.fednclient.grpc.ConnectorGrpcKt
import com.example.fednclient.grpc.Heartbeat
import com.example.fednclient.grpc.ModelServiceGrpcKt
import com.example.fednclient.grpc.Role
import io.grpc.CallOptions
import io.grpc.Channel
import io.grpc.ClientInterceptor
import io.grpc.ClientInterceptors
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.runBlocking
import java.io.Closeable
import java.security.cert.X509Certificate


interface IGrpcHandler {
    suspend fun sendHeartbeat(name: String)
}

//class AuthInterceptor(private val authToken: String) : ClientInterceptor {
//    override fun <ReqT, RespT> interceptCall(
//        method: io.grpc.MethodDescriptor<ReqT, RespT>,
//        callOptions: io.grpc.CallOptions,
//        next: io.grpc.Channel
//    ): io.grpc.ClientCall<ReqT, RespT> {
//        val headers = Metadata().apply {
//            val key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER)
//            put(key, "Bearer $authToken")
//        }
//
//        val newCallOptions = callOptions.withOption(
//            CallOptions.Key.createWithDefault("custom-headers", null),
//            headers
//        )
//        return next.newCall(method, newCallOptions)
//    }
//}

class GrpcHandler(
    private val url: String,
    private val port: Int,
    private val token: String,
) :
    IGrpcHandler, Closeable {

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
//
//    private var _channel: Channel? = null
//
//    val channel: Channel
//        get() {
//
//            if (_channel == null) {
//
//                _channel = ClientInterceptors.intercept(managedChannel, AuthInterceptor(token))
//            }
//
//            return _channel ?: throw AssertionError("Set to null by another thread")
//        }


    private val connectorStub: ConnectorGrpcKt.ConnectorCoroutineStub =
        ConnectorGrpcKt.ConnectorCoroutineStub(managedChannel)

    val combinerStub: CombinerGrpcKt.CombinerCoroutineStub =
        CombinerGrpcKt.CombinerCoroutineStub(managedChannel)

    val modelServiceStub: ModelServiceGrpcKt.ModelServiceCoroutineStub =
        ModelServiceGrpcKt.ModelServiceCoroutineStub(managedChannel)

    override suspend fun sendHeartbeat(name: String) {

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

            connectorStub.sendHeartbeat(request)
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    override fun close() {

        managedChannel.shutdown()
    }
}