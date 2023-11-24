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
import io.grpc.Status
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
 * Holder for Kotlin coroutine-based client and server APIs for grpc.ModelService.
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
   * A stub for issuing RPCs to a(n) grpc.ModelService service as suspending coroutines.
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
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
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
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun download(request: ModelRequest, headers: Metadata = Metadata()):
        Flow<ModelResponse> = serverStreamingRpc(
      channel,
      ModelServiceGrpc.getDownloadMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the grpc.ModelService service based on Kotlin coroutines.
   */
  public abstract class ModelServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for grpc.ModelService.Upload.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    public open suspend fun upload(requests: Flow<ModelRequest>): ModelResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.ModelService.Upload is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for grpc.ModelService.Download.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun download(request: ModelRequest): Flow<ModelResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.ModelService.Download is unimplemented"))

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
 * Holder for Kotlin coroutine-based client and server APIs for grpc.Control.
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

  public val configureMethod: MethodDescriptor<ControlRequest, ReportResponse>
    @JvmStatic
    get() = ControlGrpc.getConfigureMethod()

  public val reportMethod: MethodDescriptor<ControlRequest, ReportResponse>
    @JvmStatic
    get() = ControlGrpc.getReportMethod()

  /**
   * A stub for issuing RPCs to a(n) grpc.Control service as suspending coroutines.
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
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
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
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
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
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun configure(request: ControlRequest, headers: Metadata = Metadata()):
        ReportResponse = unaryRpc(
      channel,
      ControlGrpc.getConfigureMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun report(request: ControlRequest, headers: Metadata = Metadata()):
        ReportResponse = unaryRpc(
      channel,
      ControlGrpc.getReportMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the grpc.Control service based on Kotlin coroutines.
   */
  public abstract class ControlCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for grpc.Control.Start.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun start(request: ControlRequest): ControlResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Control.Start is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Control.Stop.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun stop(request: ControlRequest): ControlResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Control.Stop is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Control.Configure.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun configure(request: ControlRequest): ReportResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Control.Configure is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Control.Report.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun report(request: ControlRequest): ReportResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Control.Report is unimplemented"))

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
      descriptor = ControlGrpc.getConfigureMethod(),
      implementation = ::configure
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ControlGrpc.getReportMethod(),
      implementation = ::report
    )).build()
  }
}

/**
 * Holder for Kotlin coroutine-based client and server APIs for grpc.Reducer.
 */
public object ReducerGrpcKt {
  public const val SERVICE_NAME: String = ReducerGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = ReducerGrpc.getServiceDescriptor()

  public val getGlobalModelMethod:
      MethodDescriptor<GetGlobalModelRequest, GetGlobalModelResponse>
    @JvmStatic
    get() = ReducerGrpc.getGetGlobalModelMethod()

  /**
   * A stub for issuing RPCs to a(n) grpc.Reducer service as suspending coroutines.
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
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
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
   * Skeletal implementation of the grpc.Reducer service based on Kotlin coroutines.
   */
  public abstract class ReducerCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for grpc.Reducer.GetGlobalModel.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getGlobalModel(request: GetGlobalModelRequest):
        GetGlobalModelResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Reducer.GetGlobalModel is unimplemented"))

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
 * Holder for Kotlin coroutine-based client and server APIs for grpc.Connector.
 */
public object ConnectorGrpcKt {
  public const val SERVICE_NAME: String = ConnectorGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = ConnectorGrpc.getServiceDescriptor()

  public val allianceStatusStreamMethod: MethodDescriptor<ClientAvailableMessage, com.example.fedn_client.grpc.Status>
    @JvmStatic
    get() = ConnectorGrpc.getAllianceStatusStreamMethod()

  public val sendStatusMethod: MethodDescriptor<com.example.fedn_client.grpc.Status, Response>
    @JvmStatic
    get() = ConnectorGrpc.getSendStatusMethod()

  public val listActiveClientsMethod: MethodDescriptor<ListClientsRequest, ClientList>
    @JvmStatic
    get() = ConnectorGrpc.getListActiveClientsMethod()

  public val acceptingClientsMethod:
      MethodDescriptor<ConnectionRequest, ConnectionResponse>
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
   * A stub for issuing RPCs to a(n) grpc.Connector service as suspending coroutines.
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
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
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
        Metadata()): Flow<com.example.fedn_client.grpc.Status> = serverStreamingRpc(
      channel,
      ConnectorGrpc.getAllianceStatusStreamMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun sendStatus(request: com.example.fedn_client.grpc.Status, headers: Metadata = Metadata()):
        Response = unaryRpc(
      channel,
      ConnectorGrpc.getSendStatusMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
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
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun acceptingClients(request: ConnectionRequest, headers: Metadata =
        Metadata()): ConnectionResponse = unaryRpc(
      channel,
      ConnectorGrpc.getAcceptingClientsMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun sendHeartbeat(request: Heartbeat, headers: Metadata = Metadata()):
        Response = unaryRpc(
      channel,
      ConnectorGrpc.getSendHeartbeatMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun reassignClient(request: ReassignRequest, headers: Metadata =
        Metadata()): Response = unaryRpc(
      channel,
      ConnectorGrpc.getReassignClientMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun reconnectClient(request: ReconnectRequest, headers: Metadata =
        Metadata()): Response = unaryRpc(
      channel,
      ConnectorGrpc.getReconnectClientMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the grpc.Connector service based on Kotlin coroutines.
   */
  public abstract class ConnectorCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns a [Flow] of responses to an RPC for grpc.Connector.AllianceStatusStream.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun allianceStatusStream(request: ClientAvailableMessage): Flow<com.example.fedn_client.grpc.Status> =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Connector.AllianceStatusStream is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Connector.SendStatus.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendStatus(request: com.example.fedn_client.grpc.Status): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Connector.SendStatus is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Connector.ListActiveClients.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun listActiveClients(request: ListClientsRequest): ClientList =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Connector.ListActiveClients is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Connector.AcceptingClients.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun acceptingClients(request: ConnectionRequest):
        ConnectionResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Connector.AcceptingClients is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Connector.SendHeartbeat.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendHeartbeat(request: Heartbeat): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Connector.SendHeartbeat is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Connector.ReassignClient.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun reassignClient(request: ReassignRequest): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Connector.ReassignClient is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Connector.ReconnectClient.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun reconnectClient(request: ReconnectRequest): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Connector.ReconnectClient is unimplemented"))

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
 * Holder for Kotlin coroutine-based client and server APIs for grpc.Combiner.
 */
public object CombinerGrpcKt {
  public const val SERVICE_NAME: String = CombinerGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = CombinerGrpc.getServiceDescriptor()

  public val modelUpdateRequestStreamMethod:
      MethodDescriptor<ClientAvailableMessage, ModelUpdateRequest>
    @JvmStatic
    get() = CombinerGrpc.getModelUpdateRequestStreamMethod()

  public val modelUpdateStreamMethod:
      MethodDescriptor<ClientAvailableMessage, ModelUpdate>
    @JvmStatic
    get() = CombinerGrpc.getModelUpdateStreamMethod()

  public val modelValidationRequestStreamMethod:
      MethodDescriptor<ClientAvailableMessage, ModelValidationRequest>
    @JvmStatic
    get() = CombinerGrpc.getModelValidationRequestStreamMethod()

  public val modelValidationStreamMethod:
      MethodDescriptor<ClientAvailableMessage, ModelValidation>
    @JvmStatic
    get() = CombinerGrpc.getModelValidationStreamMethod()

  public val sendModelUpdateRequestMethod: MethodDescriptor<ModelUpdateRequest, Response>
    @JvmStatic
    get() = CombinerGrpc.getSendModelUpdateRequestMethod()

  public val sendModelUpdateMethod: MethodDescriptor<ModelUpdate, Response>
    @JvmStatic
    get() = CombinerGrpc.getSendModelUpdateMethod()

  public val sendModelValidationRequestMethod:
      MethodDescriptor<ModelValidationRequest, Response>
    @JvmStatic
    get() = CombinerGrpc.getSendModelValidationRequestMethod()

  public val sendModelValidationMethod: MethodDescriptor<ModelValidation, Response>
    @JvmStatic
    get() = CombinerGrpc.getSendModelValidationMethod()

  /**
   * A stub for issuing RPCs to a(n) grpc.Combiner service as suspending coroutines.
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
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun modelUpdateRequestStream(request: ClientAvailableMessage, headers: Metadata =
        Metadata()): Flow<ModelUpdateRequest> = serverStreamingRpc(
      channel,
      CombinerGrpc.getModelUpdateRequestStreamMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun modelUpdateStream(request: ClientAvailableMessage, headers: Metadata =
        Metadata()): Flow<ModelUpdate> = serverStreamingRpc(
      channel,
      CombinerGrpc.getModelUpdateStreamMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun modelValidationRequestStream(request: ClientAvailableMessage, headers: Metadata
        = Metadata()): Flow<ModelValidationRequest> = serverStreamingRpc(
      channel,
      CombinerGrpc.getModelValidationRequestStreamMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun modelValidationStream(request: ClientAvailableMessage, headers: Metadata =
        Metadata()): Flow<ModelValidation> = serverStreamingRpc(
      channel,
      CombinerGrpc.getModelValidationStreamMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun sendModelUpdateRequest(request: ModelUpdateRequest, headers: Metadata =
        Metadata()): Response = unaryRpc(
      channel,
      CombinerGrpc.getSendModelUpdateRequestMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
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
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun sendModelValidationRequest(request: ModelValidationRequest,
        headers: Metadata = Metadata()): Response = unaryRpc(
      channel,
      CombinerGrpc.getSendModelValidationRequestMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
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
   * Skeletal implementation of the grpc.Combiner service based on Kotlin coroutines.
   */
  public abstract class CombinerCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns a [Flow] of responses to an RPC for grpc.Combiner.ModelUpdateRequestStream.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun modelUpdateRequestStream(request: ClientAvailableMessage):
        Flow<ModelUpdateRequest> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Combiner.ModelUpdateRequestStream is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for grpc.Combiner.ModelUpdateStream.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun modelUpdateStream(request: ClientAvailableMessage): Flow<ModelUpdate>
        = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Combiner.ModelUpdateStream is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for grpc.Combiner.ModelValidationRequestStream.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun modelValidationRequestStream(request: ClientAvailableMessage):
        Flow<ModelValidationRequest> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Combiner.ModelValidationRequestStream is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for grpc.Combiner.ModelValidationStream.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun modelValidationStream(request: ClientAvailableMessage):
        Flow<ModelValidation> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Combiner.ModelValidationStream is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Combiner.SendModelUpdateRequest.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendModelUpdateRequest(request: ModelUpdateRequest): Response
        = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Combiner.SendModelUpdateRequest is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Combiner.SendModelUpdate.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendModelUpdate(request: ModelUpdate): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Combiner.SendModelUpdate is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Combiner.SendModelValidationRequest.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendModelValidationRequest(request: ModelValidationRequest):
        Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Combiner.SendModelValidationRequest is unimplemented"))

    /**
     * Returns the response to an RPC for grpc.Combiner.SendModelValidation.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendModelValidation(request: ModelValidation): Response =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method grpc.Combiner.SendModelValidation is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(CombinerGrpc.getServiceDescriptor())
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getModelUpdateRequestStreamMethod(),
      implementation = ::modelUpdateRequestStream
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getModelUpdateStreamMethod(),
      implementation = ::modelUpdateStream
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getModelValidationRequestStreamMethod(),
      implementation = ::modelValidationRequestStream
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getModelValidationStreamMethod(),
      implementation = ::modelValidationStream
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getSendModelUpdateRequestMethod(),
      implementation = ::sendModelUpdateRequest
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getSendModelUpdateMethod(),
      implementation = ::sendModelUpdate
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getSendModelValidationRequestMethod(),
      implementation = ::sendModelValidationRequest
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CombinerGrpc.getSendModelValidationMethod(),
      implementation = ::sendModelValidation
    )).build()
  }
}
