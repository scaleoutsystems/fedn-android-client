package com.example.fednclient.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: fedn.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConnectorGrpc {

  private ConnectorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "grpc.Connector";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.ClientAvailableMessage,
      com.example.fednclient.grpc.Status> getAllianceStatusStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AllianceStatusStream",
      requestType = com.example.fednclient.grpc.ClientAvailableMessage.class,
      responseType = com.example.fednclient.grpc.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.ClientAvailableMessage,
      com.example.fednclient.grpc.Status> getAllianceStatusStreamMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.ClientAvailableMessage, com.example.fednclient.grpc.Status> getAllianceStatusStreamMethod;
    if ((getAllianceStatusStreamMethod = ConnectorGrpc.getAllianceStatusStreamMethod) == null) {
      synchronized (ConnectorGrpc.class) {
        if ((getAllianceStatusStreamMethod = ConnectorGrpc.getAllianceStatusStreamMethod) == null) {
          ConnectorGrpc.getAllianceStatusStreamMethod = getAllianceStatusStreamMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.ClientAvailableMessage, com.example.fednclient.grpc.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AllianceStatusStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ClientAvailableMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.Status.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectorMethodDescriptorSupplier("AllianceStatusStream"))
              .build();
        }
      }
    }
    return getAllianceStatusStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.Status,
      com.example.fednclient.grpc.Response> getSendStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendStatus",
      requestType = com.example.fednclient.grpc.Status.class,
      responseType = com.example.fednclient.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.Status,
      com.example.fednclient.grpc.Response> getSendStatusMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.Status, com.example.fednclient.grpc.Response> getSendStatusMethod;
    if ((getSendStatusMethod = ConnectorGrpc.getSendStatusMethod) == null) {
      synchronized (ConnectorGrpc.class) {
        if ((getSendStatusMethod = ConnectorGrpc.getSendStatusMethod) == null) {
          ConnectorGrpc.getSendStatusMethod = getSendStatusMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.Status, com.example.fednclient.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.Status.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectorMethodDescriptorSupplier("SendStatus"))
              .build();
        }
      }
    }
    return getSendStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.ListClientsRequest,
      com.example.fednclient.grpc.ClientList> getListActiveClientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListActiveClients",
      requestType = com.example.fednclient.grpc.ListClientsRequest.class,
      responseType = com.example.fednclient.grpc.ClientList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.ListClientsRequest,
      com.example.fednclient.grpc.ClientList> getListActiveClientsMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.ListClientsRequest, com.example.fednclient.grpc.ClientList> getListActiveClientsMethod;
    if ((getListActiveClientsMethod = ConnectorGrpc.getListActiveClientsMethod) == null) {
      synchronized (ConnectorGrpc.class) {
        if ((getListActiveClientsMethod = ConnectorGrpc.getListActiveClientsMethod) == null) {
          ConnectorGrpc.getListActiveClientsMethod = getListActiveClientsMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.ListClientsRequest, com.example.fednclient.grpc.ClientList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListActiveClients"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ListClientsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ClientList.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectorMethodDescriptorSupplier("ListActiveClients"))
              .build();
        }
      }
    }
    return getListActiveClientsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.ConnectionRequest,
      com.example.fednclient.grpc.ConnectionResponse> getAcceptingClientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcceptingClients",
      requestType = com.example.fednclient.grpc.ConnectionRequest.class,
      responseType = com.example.fednclient.grpc.ConnectionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.ConnectionRequest,
      com.example.fednclient.grpc.ConnectionResponse> getAcceptingClientsMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.ConnectionRequest, com.example.fednclient.grpc.ConnectionResponse> getAcceptingClientsMethod;
    if ((getAcceptingClientsMethod = ConnectorGrpc.getAcceptingClientsMethod) == null) {
      synchronized (ConnectorGrpc.class) {
        if ((getAcceptingClientsMethod = ConnectorGrpc.getAcceptingClientsMethod) == null) {
          ConnectorGrpc.getAcceptingClientsMethod = getAcceptingClientsMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.ConnectionRequest, com.example.fednclient.grpc.ConnectionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AcceptingClients"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ConnectionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectorMethodDescriptorSupplier("AcceptingClients"))
              .build();
        }
      }
    }
    return getAcceptingClientsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.Heartbeat,
      com.example.fednclient.grpc.Response> getSendHeartbeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendHeartbeat",
      requestType = com.example.fednclient.grpc.Heartbeat.class,
      responseType = com.example.fednclient.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.Heartbeat,
      com.example.fednclient.grpc.Response> getSendHeartbeatMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.Heartbeat, com.example.fednclient.grpc.Response> getSendHeartbeatMethod;
    if ((getSendHeartbeatMethod = ConnectorGrpc.getSendHeartbeatMethod) == null) {
      synchronized (ConnectorGrpc.class) {
        if ((getSendHeartbeatMethod = ConnectorGrpc.getSendHeartbeatMethod) == null) {
          ConnectorGrpc.getSendHeartbeatMethod = getSendHeartbeatMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.Heartbeat, com.example.fednclient.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendHeartbeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.Heartbeat.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectorMethodDescriptorSupplier("SendHeartbeat"))
              .build();
        }
      }
    }
    return getSendHeartbeatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.ReassignRequest,
      com.example.fednclient.grpc.Response> getReassignClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReassignClient",
      requestType = com.example.fednclient.grpc.ReassignRequest.class,
      responseType = com.example.fednclient.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.ReassignRequest,
      com.example.fednclient.grpc.Response> getReassignClientMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.ReassignRequest, com.example.fednclient.grpc.Response> getReassignClientMethod;
    if ((getReassignClientMethod = ConnectorGrpc.getReassignClientMethod) == null) {
      synchronized (ConnectorGrpc.class) {
        if ((getReassignClientMethod = ConnectorGrpc.getReassignClientMethod) == null) {
          ConnectorGrpc.getReassignClientMethod = getReassignClientMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.ReassignRequest, com.example.fednclient.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReassignClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ReassignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectorMethodDescriptorSupplier("ReassignClient"))
              .build();
        }
      }
    }
    return getReassignClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.ReconnectRequest,
      com.example.fednclient.grpc.Response> getReconnectClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReconnectClient",
      requestType = com.example.fednclient.grpc.ReconnectRequest.class,
      responseType = com.example.fednclient.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.ReconnectRequest,
      com.example.fednclient.grpc.Response> getReconnectClientMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.ReconnectRequest, com.example.fednclient.grpc.Response> getReconnectClientMethod;
    if ((getReconnectClientMethod = ConnectorGrpc.getReconnectClientMethod) == null) {
      synchronized (ConnectorGrpc.class) {
        if ((getReconnectClientMethod = ConnectorGrpc.getReconnectClientMethod) == null) {
          ConnectorGrpc.getReconnectClientMethod = getReconnectClientMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.ReconnectRequest, com.example.fednclient.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReconnectClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ReconnectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectorMethodDescriptorSupplier("ReconnectClient"))
              .build();
        }
      }
    }
    return getReconnectClientMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConnectorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectorStub>() {
        @java.lang.Override
        public ConnectorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectorStub(channel, callOptions);
        }
      };
    return ConnectorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConnectorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectorBlockingStub>() {
        @java.lang.Override
        public ConnectorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectorBlockingStub(channel, callOptions);
        }
      };
    return ConnectorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConnectorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectorFutureStub>() {
        @java.lang.Override
        public ConnectorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectorFutureStub(channel, callOptions);
        }
      };
    return ConnectorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Stream endpoint for status updates
     * </pre>
     */
    default void allianceStatusStream(com.example.fednclient.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAllianceStatusStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * Report endpoint
     * </pre>
     */
    default void sendStatus(com.example.fednclient.grpc.Status request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     *    rpc RegisterClient (ClientAvailableMessage) returns (Response);
     * List active clients endpoint
     * </pre>
     */
    default void listActiveClients(com.example.fednclient.grpc.ListClientsRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ClientList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListActiveClientsMethod(), responseObserver);
    }

    /**
     */
    default void acceptingClients(com.example.fednclient.grpc.ConnectionRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ConnectionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAcceptingClientsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client messaging to stay engaged.
     * </pre>
     */
    default void sendHeartbeat(com.example.fednclient.grpc.Heartbeat request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendHeartbeatMethod(), responseObserver);
    }

    /**
     */
    default void reassignClient(com.example.fednclient.grpc.ReassignRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReassignClientMethod(), responseObserver);
    }

    /**
     */
    default void reconnectClient(com.example.fednclient.grpc.ReconnectRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReconnectClientMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Connector.
   */
  public static abstract class ConnectorImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ConnectorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Connector.
   */
  public static final class ConnectorStub
      extends io.grpc.stub.AbstractAsyncStub<ConnectorStub> {
    private ConnectorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectorStub(channel, callOptions);
    }

    /**
     * <pre>
     * Stream endpoint for status updates
     * </pre>
     */
    public void allianceStatusStream(com.example.fednclient.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getAllianceStatusStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Report endpoint
     * </pre>
     */
    public void sendStatus(com.example.fednclient.grpc.Status request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *    rpc RegisterClient (ClientAvailableMessage) returns (Response);
     * List active clients endpoint
     * </pre>
     */
    public void listActiveClients(com.example.fednclient.grpc.ListClientsRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ClientList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListActiveClientsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void acceptingClients(com.example.fednclient.grpc.ConnectionRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ConnectionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptingClientsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client messaging to stay engaged.
     * </pre>
     */
    public void sendHeartbeat(com.example.fednclient.grpc.Heartbeat request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendHeartbeatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reassignClient(com.example.fednclient.grpc.ReassignRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReassignClientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reconnectClient(com.example.fednclient.grpc.ReconnectRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReconnectClientMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Connector.
   */
  public static final class ConnectorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConnectorBlockingStub> {
    private ConnectorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectorBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Stream endpoint for status updates
     * </pre>
     */
    public java.util.Iterator<com.example.fednclient.grpc.Status> allianceStatusStream(
        com.example.fednclient.grpc.ClientAvailableMessage request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getAllianceStatusStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Report endpoint
     * </pre>
     */
    public com.example.fednclient.grpc.Response sendStatus(com.example.fednclient.grpc.Status request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *    rpc RegisterClient (ClientAvailableMessage) returns (Response);
     * List active clients endpoint
     * </pre>
     */
    public com.example.fednclient.grpc.ClientList listActiveClients(com.example.fednclient.grpc.ListClientsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListActiveClientsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fednclient.grpc.ConnectionResponse acceptingClients(com.example.fednclient.grpc.ConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptingClientsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Client messaging to stay engaged.
     * </pre>
     */
    public com.example.fednclient.grpc.Response sendHeartbeat(com.example.fednclient.grpc.Heartbeat request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendHeartbeatMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fednclient.grpc.Response reassignClient(com.example.fednclient.grpc.ReassignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReassignClientMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fednclient.grpc.Response reconnectClient(com.example.fednclient.grpc.ReconnectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReconnectClientMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Connector.
   */
  public static final class ConnectorFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConnectorFutureStub> {
    private ConnectorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectorFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Report endpoint
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fednclient.grpc.Response> sendStatus(
        com.example.fednclient.grpc.Status request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *    rpc RegisterClient (ClientAvailableMessage) returns (Response);
     * List active clients endpoint
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fednclient.grpc.ClientList> listActiveClients(
        com.example.fednclient.grpc.ListClientsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListActiveClientsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fednclient.grpc.ConnectionResponse> acceptingClients(
        com.example.fednclient.grpc.ConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptingClientsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Client messaging to stay engaged.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fednclient.grpc.Response> sendHeartbeat(
        com.example.fednclient.grpc.Heartbeat request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendHeartbeatMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fednclient.grpc.Response> reassignClient(
        com.example.fednclient.grpc.ReassignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReassignClientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fednclient.grpc.Response> reconnectClient(
        com.example.fednclient.grpc.ReconnectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReconnectClientMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ALLIANCE_STATUS_STREAM = 0;
  private static final int METHODID_SEND_STATUS = 1;
  private static final int METHODID_LIST_ACTIVE_CLIENTS = 2;
  private static final int METHODID_ACCEPTING_CLIENTS = 3;
  private static final int METHODID_SEND_HEARTBEAT = 4;
  private static final int METHODID_REASSIGN_CLIENT = 5;
  private static final int METHODID_RECONNECT_CLIENT = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ALLIANCE_STATUS_STREAM:
          serviceImpl.allianceStatusStream((com.example.fednclient.grpc.ClientAvailableMessage) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Status>) responseObserver);
          break;
        case METHODID_SEND_STATUS:
          serviceImpl.sendStatus((com.example.fednclient.grpc.Status) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response>) responseObserver);
          break;
        case METHODID_LIST_ACTIVE_CLIENTS:
          serviceImpl.listActiveClients((com.example.fednclient.grpc.ListClientsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ClientList>) responseObserver);
          break;
        case METHODID_ACCEPTING_CLIENTS:
          serviceImpl.acceptingClients((com.example.fednclient.grpc.ConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ConnectionResponse>) responseObserver);
          break;
        case METHODID_SEND_HEARTBEAT:
          serviceImpl.sendHeartbeat((com.example.fednclient.grpc.Heartbeat) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response>) responseObserver);
          break;
        case METHODID_REASSIGN_CLIENT:
          serviceImpl.reassignClient((com.example.fednclient.grpc.ReassignRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response>) responseObserver);
          break;
        case METHODID_RECONNECT_CLIENT:
          serviceImpl.reconnectClient((com.example.fednclient.grpc.ReconnectRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAllianceStatusStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.fednclient.grpc.ClientAvailableMessage,
              com.example.fednclient.grpc.Status>(
                service, METHODID_ALLIANCE_STATUS_STREAM)))
        .addMethod(
          getSendStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fednclient.grpc.Status,
              com.example.fednclient.grpc.Response>(
                service, METHODID_SEND_STATUS)))
        .addMethod(
          getListActiveClientsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fednclient.grpc.ListClientsRequest,
              com.example.fednclient.grpc.ClientList>(
                service, METHODID_LIST_ACTIVE_CLIENTS)))
        .addMethod(
          getAcceptingClientsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fednclient.grpc.ConnectionRequest,
              com.example.fednclient.grpc.ConnectionResponse>(
                service, METHODID_ACCEPTING_CLIENTS)))
        .addMethod(
          getSendHeartbeatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fednclient.grpc.Heartbeat,
              com.example.fednclient.grpc.Response>(
                service, METHODID_SEND_HEARTBEAT)))
        .addMethod(
          getReassignClientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fednclient.grpc.ReassignRequest,
              com.example.fednclient.grpc.Response>(
                service, METHODID_REASSIGN_CLIENT)))
        .addMethod(
          getReconnectClientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fednclient.grpc.ReconnectRequest,
              com.example.fednclient.grpc.Response>(
                service, METHODID_RECONNECT_CLIENT)))
        .build();
  }

  private static abstract class ConnectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConnectorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.fednclient.grpc.Fedn.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Connector");
    }
  }

  private static final class ConnectorFileDescriptorSupplier
      extends ConnectorBaseDescriptorSupplier {
    ConnectorFileDescriptorSupplier() {}
  }

  private static final class ConnectorMethodDescriptorSupplier
      extends ConnectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConnectorMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConnectorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConnectorFileDescriptorSupplier())
              .addMethod(getAllianceStatusStreamMethod())
              .addMethod(getSendStatusMethod())
              .addMethod(getListActiveClientsMethod())
              .addMethod(getAcceptingClientsMethod())
              .addMethod(getSendHeartbeatMethod())
              .addMethod(getReassignClientMethod())
              .addMethod(getReconnectClientMethod())
              .build();
        }
      }
    }
    return result;
  }
}
