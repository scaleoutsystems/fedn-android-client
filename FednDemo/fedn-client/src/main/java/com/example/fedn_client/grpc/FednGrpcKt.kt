package com.example.fedn_client.grpc

import com.example.fedn_client.grpc.ModelServiceGrpc.getServiceDescriptor
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.clientStreamingRpc
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.clientStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * com.example.fedn_client.grpc.ModelService.
 */
public object ModelServiceGrpcKt {
  public const val SERVICE_NAME: String = ModelServiceGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = ModelServiceGrpc.getServiceDescriptor()

  public val uploadMethod: MethodDescriptor<ModelRequest, ModelResponse>
    @JvmStatic
    get() = ModelServiceGrpc.getUploadMethod()

  public val downloadMethod: MethodDescriptor<ModelRequest, ModelResponse>
    @JvmStatic
    get() = ModelServiceGrpc.getDownloadMethod()

  /**
   * A stub for issuing RPCs to a(n) com.example.fedn_client.grpc.ModelService service as suspending
   * coroutines.
   */
  @StubFor(ModelServiceGrpc::class)
  public class ModelServiceCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<ModelServiceCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): ModelServiceCoroutineStub
        = ModelServiceCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * This function collects the [Flow] of requests.  If the server terminates the RPC
     * for any reason before collection of requests is complete, the collection of requests
     * will be cancelled.  If the collection of requests completes exceptionally for any other
     * reason, the RPC will be cancelled for that reason and this method will throw that
     * exception.
     *
     * @param requests A [Flow] of request messages.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun upload(requests: Flow<ModelRequest>, headers: Metadata = Metadata()):
        ModelResponse = clientStreamingRpc(
      channel,
      ModelServiceGrpc.getUploadMethod(),
      requests,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun download(request: ModelRequest, headers: Metadata = Metadata()): Flow<ModelResponse>
        = serverStreamingRpc(
      channel,
      ModelServiceGrpc.getDownloadMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the com.example.fedn_client.grpc.ModelService service based on
   * Kotlin coroutines.
   */
  public abstract class ModelServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.ModelService.Upload.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    public open suspend fun upload(requests: Flow<ModelRequest>): ModelResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.ModelService.Upload is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * com.example.fedn_client.grpc.ModelService.Download.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun download(request: ModelRequest): Flow<ModelResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.ModelService.Download is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(getServiceDescriptor())
      .addMethod(clientStreamingServerMethodDefinition(
      context = this.context,
      descriptor = ModelServiceGrpc.getUploadMethod(),
      implementation = ::upload
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = ModelServiceGrpc.getDownloadMethod(),
      implementation = ::download
    )).build()
  }
}

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * com.example.fedn_client.grpc.Control.
 */
public object ControlGrpcKt {
  public const val SERVICE_NAME: String = ControlGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = ControlGrpc.getServiceDescriptor()

  public val startMethod: MethodDescriptor<ControlRequest, ControlResponse>
    @JvmStatic
    get() = ControlGrpc.getStartMethod()

  public val stopMethod: MethodDescriptor<ControlRequest, ControlResponse>
    @JvmStatic
    get() = ControlGrpc.getStopMethod()

  public val flushAggregationQueueMethod: MethodDescriptor<ControlRequest, ControlResponse>
    @JvmStatic
    get() = ControlGrpc.getFlushAggregationQueueMethod()

  public val setAggregatorMethod: MethodDescriptor<ControlRequest, ControlResponse>
    @JvmStatic
    get() = ControlGrpc.getSetAggregatorMethod()

  /**
   * A stub for issuing RPCs to a(n) com.example.fedn_client.grpc.Control service as suspending
   * coroutines.
   */
  @StubFor(ControlGrpc::class)
  public class ControlCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<ControlCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): ControlCoroutineStub =
        ControlCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun start(request: ControlRequest, headers: Metadata = Metadata()):
        ControlResponse = unaryRpc(
      channel,
      ControlGrpc.getStartMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun stop(request: ControlRequest, headers: Metadata = Metadata()):
        ControlResponse = unaryRpc(
      channel,
      ControlGrpc.getStopMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun flushAggregationQueue(request: ControlRequest, headers: Metadata =
        Metadata()): ControlResponse = unaryRpc(
      channel,
      ControlGrpc.getFlushAggregationQueueMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun setAggregator(request: ControlRequest, headers: Metadata = Metadata()):
        ControlResponse = unaryRpc(
      channel,
      ControlGrpc.getSetAggregatorMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the com.example.fedn_client.grpc.Control service based on Kotlin
   * coroutines.
   */
  public abstract class ControlCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Control.Start.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun start(request: ControlRequest): ControlResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Control.Start is unimplemented"))

    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Control.Stop.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun stop(request: ControlRequest): ControlResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Control.Stop is unimplemented"))

    /**
     * Returns the response to an RPC for
     * com.example.fedn_client.grpc.Control.FlushAggregationQueue.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun flushAggregationQueue(request: ControlRequest): ControlResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Control.FlushAggregationQueue is unimplemented"))

    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Control.SetAggregator.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun setAggregator(request: ControlRequest): ControlResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Control.SetAggregator is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(ControlGrpc.getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ControlGrpc.getStartMethod(),
      implementation = ::start
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ControlGrpc.getStopMethod(),
      implementation = ::stop
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ControlGrpc.getFlushAggregationQueueMethod(),
      implementation = ::flushAggregationQueue
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ControlGrpc.getSetAggregatorMethod(),
      implementation = ::setAggregator
    )).build()
  }
}

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * com.example.fedn_client.grpc.Reducer.
 */
public object ReducerGrpcKt {
  public const val SERVICE_NAME: String = ReducerGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = ReducerGrpc.getServiceDescriptor()

  public val getGlobalModelMethod: MethodDescriptor<GetGlobalModelRequest, GetGlobalModelResponse>
    @JvmStatic
    get() = ReducerGrpc.getGetGlobalModelMethod()

  /**
   * A stub for issuing RPCs to a(n) com.example.fedn_client.grpc.Reducer service as suspending
   * coroutines.
   */
  @StubFor(ReducerGrpc::class)
  public class ReducerCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<ReducerCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): ReducerCoroutineStub =
        ReducerCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getGlobalModel(request: GetGlobalModelRequest, headers: Metadata =
        Metadata()): GetGlobalModelResponse = unaryRpc(
      channel,
      ReducerGrpc.getGetGlobalModelMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the com.example.fedn_client.grpc.Reducer service based on Kotlin
   * coroutines.
   */
  public abstract class ReducerCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Reducer.GetGlobalModel.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getGlobalModel(request: GetGlobalModelRequest): GetGlobalModelResponse =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Reducer.GetGlobalModel is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(ReducerGrpc.getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ReducerGrpc.getGetGlobalModelMethod(),
      implementation = ::getGlobalModel
    )).build()
  }
}

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * com.example.fedn_client.grpc.Connector.
 */
public object ConnectorGrpcKt {
  public const val SERVICE_NAME: String = ConnectorGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = ConnectorGrpc.getServiceDescriptor()

  public val allianceStatusStreamMethod: MethodDescriptor<ClientAvailableMessage, Status>
    @JvmStatic
    get() = ConnectorGrpc.getAllianceStatusStreamMethod()

  public val sendStatusMethod: MethodDescriptor<Status, Response>
    @JvmStatic
    get() = ConnectorGrpc.getSendStatusMethod()

  public val listActiveClientsMethod: MethodDescriptor<ListClientsRequest, ClientList>
    @JvmStatic
    get() = ConnectorGrpc.getListActiveClientsMethod()

  public val acceptingClientsMethod: MethodDescriptor<ConnectionRequest, ConnectionResponse>
    @JvmStatic
    get() = ConnectorGrpc.getAcceptingClientsMethod()

  public val sendHeartbeatMethod: MethodDescriptor<Heartbeat, Response>
    @JvmStatic
    get() = ConnectorGrpc.getSendHeartbeatMethod()

  public val reassignClientMethod: MethodDescriptor<ReassignRequest, Response>
    @JvmStatic
    get() = ConnectorGrpc.getReassignClientMethod()

  public val reconnectClientMethod: MethodDescriptor<ReconnectRequest, Response>
    @JvmStatic
    get() = ConnectorGrpc.getReconnectClientMethod()

  /**
   * A stub for issuing RPCs to a(n) com.example.fedn_client.grpc.Connector service as suspending
   * coroutines.
   */
  @StubFor(ConnectorGrpc::class)
  public class ConnectorCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<ConnectorCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): ConnectorCoroutineStub =
        ConnectorCoroutineStub(channel, callOptions)

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun allianceStatusStream(request: ClientAvailableMessage, headers: Metadata =
        Metadata()): Flow<Status> = serverStreamingRpc(
      channel,
      ConnectorGrpc.getAllianceStatusStreamMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun sendStatus(request: Status, headers: Metadata = Metadata()): Response =
        unaryRpc(
      channel,
      ConnectorGrpc.getSendStatusMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun listActiveClients(request: ListClientsRequest, headers: Metadata =
        Metadata()): ClientList = unaryRpc(
      channel,
      ConnectorGrpc.getListActiveClientsMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun acceptingClients(request: ConnectionRequest, headers: Metadata = Metadata()):
        ConnectionResponse = unaryRpc(
      channel,
      ConnectorGrpc.getAcceptingClientsMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun sendHeartbeat(request: Heartbeat, headers: Metadata = Metadata()): Response =
        unaryRpc(
      channel,
      ConnectorGrpc.getSendHeartbeatMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun reassignClient(request: ReassignRequest, headers: Metadata = Metadata()):
        Response = unaryRpc(
      channel,
      ConnectorGrpc.getReassignClientMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun reconnectClient(request: ReconnectRequest, headers: Metadata = Metadata()):
        Response = unaryRpc(
      channel,
      ConnectorGrpc.getReconnectClientMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the com.example.fedn_client.grpc.Connector service based on Kotlin
   * coroutines.
   */
  public abstract class ConnectorCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns a [Flow] of responses to an RPC for
     * com.example.fedn_client.grpc.Connector.AllianceStatusStream.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun allianceStatusStream(request: ClientAvailableMessage): Flow<Status> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Connector.AllianceStatusStream is unimplemented"))

    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Connector.SendStatus.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendStatus(request: Status): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Connector.SendStatus is unimplemented"))

    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Connector.ListActiveClients.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun listActiveClients(request: ListClientsRequest): ClientList = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Connector.ListActiveClients is unimplemented"))

    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Connector.AcceptingClients.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun acceptingClients(request: ConnectionRequest): ConnectionResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Connector.AcceptingClients is unimplemented"))

    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Connector.SendHeartbeat.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendHeartbeat(request: Heartbeat): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Connector.SendHeartbeat is unimplemented"))

    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Connector.ReassignClient.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun reassignClient(request: ReassignRequest): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Connector.ReassignClient is unimplemented"))

    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Connector.ReconnectClient.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun reconnectClient(request: ReconnectRequest): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Connector.ReconnectClient is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(ConnectorGrpc.getServiceDescriptor())
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = ConnectorGrpc.getAllianceStatusStreamMethod(),
      implementation = ::allianceStatusStream
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ConnectorGrpc.getSendStatusMethod(),
      implementation = ::sendStatus
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ConnectorGrpc.getListActiveClientsMethod(),
      implementation = ::listActiveClients
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ConnectorGrpc.getAcceptingClientsMethod(),
      implementation = ::acceptingClients
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ConnectorGrpc.getSendHeartbeatMethod(),
      implementation = ::sendHeartbeat
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ConnectorGrpc.getReassignClientMethod(),
      implementation = ::reassignClient
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ConnectorGrpc.getReconnectClientMethod(),
      implementation = ::reconnectClient
    )).build()
  }
}

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * com.example.fedn_client.grpc.Combiner.
 */
public object CombinerGrpcKt {
  public const val SERVICE_NAME: String = CombinerGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = CombinerGrpc.getServiceDescriptor()

  public val taskStreamMethod: MethodDescriptor<ClientAvailableMessage, TaskRequest>
    @JvmStatic
    get() = CombinerGrpc.getTaskStreamMethod()

  public val sendModelUpdateMethod: MethodDescriptor<ModelUpdate, Response>
    @JvmStatic
    get() = CombinerGrpc.getSendModelUpdateMethod()

  public val sendModelValidationMethod: MethodDescriptor<ModelValidation, Response>
    @JvmStatic
    get() = CombinerGrpc.getSendModelValidationMethod()

  /**
   * A stub for issuing RPCs to a(n) com.example.fedn_client.grpc.Combiner service as suspending
   * coroutines.
   */
  @StubFor(CombinerGrpc::class)
  public class CombinerCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<CombinerCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): CombinerCoroutineStub =
        CombinerCoroutineStub(channel, callOptions)

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun taskStream(request: ClientAvailableMessage, headers: Metadata = Metadata()):
        Flow<TaskRequest> = serverStreamingRpc(
      channel,
      CombinerGrpc.getTaskStreamMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun sendModelUpdate(request: ModelUpdate, headers: Metadata = Metadata()):
        Response = unaryRpc(
      channel,
      CombinerGrpc.getSendModelUpdateMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun sendModelValidation(request: ModelValidation, headers: Metadata =
        Metadata()): Response = unaryRpc(
      channel,
      CombinerGrpc.getSendModelValidationMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the com.example.fedn_client.grpc.Combiner service based on Kotlin
   * coroutines.
   */
  public abstract class CombinerCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns a [Flow] of responses to an RPC for com.example.fedn_client.grpc.Combiner.TaskStream.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun taskStream(request: ClientAvailableMessage): Flow<TaskRequest> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Combiner.TaskStream is unimplemented"))

    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Combiner.SendModelUpdate.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendModelUpdate(request: ModelUpdate): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Combiner.SendModelUpdate is unimplemented"))

    /**
     * Returns the response to an RPC for com.example.fedn_client.grpc.Combiner.SendModelValidation.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendModelValidation(request: ModelValidation): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.fedn_client.grpc.Combiner.SendModelValidation is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(CombinerGrpc.getServiceDescriptor())
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getTaskStreamMethod(),
      implementation = ::taskStream
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getSendModelUpdateMethod(),
      implementation = ::sendModelUpdate
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getSendModelValidationMethod(),
      implementation = ::sendModelValidation
    )).build()
  }
}
