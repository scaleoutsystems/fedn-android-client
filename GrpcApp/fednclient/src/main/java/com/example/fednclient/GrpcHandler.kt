package com.example.fednclient

import com.example.fednclient.grpc.CombinerGrpcKt
import com.example.fednclient.grpc.ConnectorGrpc
import com.example.fednclient.grpc.ConnectorGrpc.ConnectorStub
import com.example.fednclient.grpc.ConnectorGrpcKt
import com.example.fednclient.grpc.ModelServiceGrpcKt
import io.grpc.CallOptions
import io.grpc.Channel
import io.grpc.ClientInterceptor
import io.grpc.ClientInterceptors
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import java.io.Closeable


interface IGrpcHandler {

}

class AuthInterceptor(private val authToken: String) : ClientInterceptor {
    override fun <ReqT, RespT> interceptCall(
        method: io.grpc.MethodDescriptor<ReqT, RespT>,
        callOptions: io.grpc.CallOptions,
        next: io.grpc.Channel
    ): io.grpc.ClientCall<ReqT, RespT> {
        val headers = Metadata().apply {
            val key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER)
            put(key, "Bearer $authToken")
        }

        val newCallOptions = callOptions.withOption(
            CallOptions.Key.createWithDefault("custom-headers", null),
            headers
        )
        return next.newCall(method, newCallOptions)
    }
}

class GrpcHandler(private val url: String, private val port: Int, private val token: String) : IGrpcHandler,
    Closeable {

    private var _managedChannel: ManagedChannel? = null

    private val managedChannel: ManagedChannel
        get() {

            if (_managedChannel == null) {

                _managedChannel = ManagedChannelBuilder.forAddress(url, port).usePlaintext().build()
            }

            return _managedChannel ?: throw AssertionError("Set to null by another thread")
        }

    private var _channel: Channel? = null

    val channel: Channel
        get() {

            if (_channel == null) {

                _channel = ClientInterceptors.intercept(managedChannel, AuthInterceptor(token))
            }

            return _channel ?: throw AssertionError("Set to null by another thread")
        }

    val connectorStub: ConnectorGrpcKt.ConnectorCoroutineStub =
        ConnectorGrpcKt.ConnectorCoroutineStub(channel)

    val combinerStub: CombinerGrpcKt.CombinerCoroutineStub =
        CombinerGrpcKt.CombinerCoroutineStub(channel)

    val modelServiceStub: ModelServiceGrpcKt.ModelServiceCoroutineStub =
        ModelServiceGrpcKt.ModelServiceCoroutineStub(channel)

    override fun close() {

        managedChannel.shutdown()
    }
}