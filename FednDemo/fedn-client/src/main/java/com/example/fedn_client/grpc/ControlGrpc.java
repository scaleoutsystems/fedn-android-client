package com.example.fedn_client.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: fedn.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ControlGrpc {

  private ControlGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.fedn_client.grpc.Control";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest,
      com.example.fedn_client.grpc.ControlResponse> getStartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Start",
      requestType = com.example.fedn_client.grpc.ControlRequest.class,
      responseType = com.example.fedn_client.grpc.ControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest,
      com.example.fedn_client.grpc.ControlResponse> getStartMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest, com.example.fedn_client.grpc.ControlResponse> getStartMethod;
    if ((getStartMethod = ControlGrpc.getStartMethod) == null) {
      synchronized (ControlGrpc.class) {
        if ((getStartMethod = ControlGrpc.getStartMethod) == null) {
          ControlGrpc.getStartMethod = getStartMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ControlRequest, com.example.fedn_client.grpc.ControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Start"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ControlMethodDescriptorSupplier("Start"))
              .build();
        }
      }
    }
    return getStartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest,
      com.example.fedn_client.grpc.ControlResponse> getStopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Stop",
      requestType = com.example.fedn_client.grpc.ControlRequest.class,
      responseType = com.example.fedn_client.grpc.ControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest,
      com.example.fedn_client.grpc.ControlResponse> getStopMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest, com.example.fedn_client.grpc.ControlResponse> getStopMethod;
    if ((getStopMethod = ControlGrpc.getStopMethod) == null) {
      synchronized (ControlGrpc.class) {
        if ((getStopMethod = ControlGrpc.getStopMethod) == null) {
          ControlGrpc.getStopMethod = getStopMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ControlRequest, com.example.fedn_client.grpc.ControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Stop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ControlMethodDescriptorSupplier("Stop"))
              .build();
        }
      }
    }
    return getStopMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest,
      com.example.fedn_client.grpc.ControlResponse> getFlushAggregationQueueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FlushAggregationQueue",
      requestType = com.example.fedn_client.grpc.ControlRequest.class,
      responseType = com.example.fedn_client.grpc.ControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest,
      com.example.fedn_client.grpc.ControlResponse> getFlushAggregationQueueMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest, com.example.fedn_client.grpc.ControlResponse> getFlushAggregationQueueMethod;
    if ((getFlushAggregationQueueMethod = ControlGrpc.getFlushAggregationQueueMethod) == null) {
      synchronized (ControlGrpc.class) {
        if ((getFlushAggregationQueueMethod = ControlGrpc.getFlushAggregationQueueMethod) == null) {
          ControlGrpc.getFlushAggregationQueueMethod = getFlushAggregationQueueMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ControlRequest, com.example.fedn_client.grpc.ControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FlushAggregationQueue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ControlMethodDescriptorSupplier("FlushAggregationQueue"))
              .build();
        }
      }
    }
    return getFlushAggregationQueueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest,
      com.example.fedn_client.grpc.ControlResponse> getSetAggregatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetAggregator",
      requestType = com.example.fedn_client.grpc.ControlRequest.class,
      responseType = com.example.fedn_client.grpc.ControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest,
      com.example.fedn_client.grpc.ControlResponse> getSetAggregatorMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ControlRequest, com.example.fedn_client.grpc.ControlResponse> getSetAggregatorMethod;
    if ((getSetAggregatorMethod = ControlGrpc.getSetAggregatorMethod) == null) {
      synchronized (ControlGrpc.class) {
        if ((getSetAggregatorMethod = ControlGrpc.getSetAggregatorMethod) == null) {
          ControlGrpc.getSetAggregatorMethod = getSetAggregatorMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ControlRequest, com.example.fedn_client.grpc.ControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetAggregator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ControlMethodDescriptorSupplier("SetAggregator"))
              .build();
        }
      }
    }
    return getSetAggregatorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ControlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlStub>() {
        @java.lang.Override
        public ControlStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlStub(channel, callOptions);
        }
      };
    return ControlStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlBlockingStub>() {
        @java.lang.Override
        public ControlBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlBlockingStub(channel, callOptions);
        }
      };
    return ControlBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlFutureStub>() {
        @java.lang.Override
        public ControlFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlFutureStub(channel, callOptions);
        }
      };
    return ControlFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void start(com.example.fedn_client.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartMethod(), responseObserver);
    }

    /**
     */
    default void stop(com.example.fedn_client.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopMethod(), responseObserver);
    }

    /**
     */
    default void flushAggregationQueue(com.example.fedn_client.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFlushAggregationQueueMethod(), responseObserver);
    }

    /**
     */
    default void setAggregator(com.example.fedn_client.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetAggregatorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Control.
   */
  public static abstract class ControlImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ControlGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Control.
   */
  public static final class ControlStub
      extends io.grpc.stub.AbstractAsyncStub<ControlStub> {
    private ControlStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlStub(channel, callOptions);
    }

    /**
     */
    public void start(com.example.fedn_client.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stop(com.example.fedn_client.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void flushAggregationQueue(com.example.fedn_client.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFlushAggregationQueueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setAggregator(com.example.fedn_client.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetAggregatorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Control.
   */
  public static final class ControlBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ControlBlockingStub> {
    private ControlBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.fedn_client.grpc.ControlResponse start(com.example.fedn_client.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fedn_client.grpc.ControlResponse stop(com.example.fedn_client.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fedn_client.grpc.ControlResponse flushAggregationQueue(com.example.fedn_client.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFlushAggregationQueueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fedn_client.grpc.ControlResponse setAggregator(com.example.fedn_client.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetAggregatorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Control.
   */
  public static final class ControlFutureStub
      extends io.grpc.stub.AbstractFutureStub<ControlFutureStub> {
    private ControlFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fedn_client.grpc.ControlResponse> start(
        com.example.fedn_client.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fedn_client.grpc.ControlResponse> stop(
        com.example.fedn_client.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fedn_client.grpc.ControlResponse> flushAggregationQueue(
        com.example.fedn_client.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFlushAggregationQueueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fedn_client.grpc.ControlResponse> setAggregator(
        com.example.fedn_client.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetAggregatorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START = 0;
  private static final int METHODID_STOP = 1;
  private static final int METHODID_FLUSH_AGGREGATION_QUEUE = 2;
  private static final int METHODID_SET_AGGREGATOR = 3;

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
        case METHODID_START:
          serviceImpl.start((com.example.fedn_client.grpc.ControlRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse>) responseObserver);
          break;
        case METHODID_STOP:
          serviceImpl.stop((com.example.fedn_client.grpc.ControlRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse>) responseObserver);
          break;
        case METHODID_FLUSH_AGGREGATION_QUEUE:
          serviceImpl.flushAggregationQueue((com.example.fedn_client.grpc.ControlRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse>) responseObserver);
          break;
        case METHODID_SET_AGGREGATOR:
          serviceImpl.setAggregator((com.example.fedn_client.grpc.ControlRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ControlResponse>) responseObserver);
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
          getStartMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ControlRequest,
              com.example.fedn_client.grpc.ControlResponse>(
                service, METHODID_START)))
        .addMethod(
          getStopMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ControlRequest,
              com.example.fedn_client.grpc.ControlResponse>(
                service, METHODID_STOP)))
        .addMethod(
          getFlushAggregationQueueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ControlRequest,
              com.example.fedn_client.grpc.ControlResponse>(
                service, METHODID_FLUSH_AGGREGATION_QUEUE)))
        .addMethod(
          getSetAggregatorMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ControlRequest,
              com.example.fedn_client.grpc.ControlResponse>(
                service, METHODID_SET_AGGREGATOR)))
        .build();
  }

  private static abstract class ControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.fedn_client.grpc.Fedn.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Control");
    }
  }

  private static final class ControlFileDescriptorSupplier
      extends ControlBaseDescriptorSupplier {
    ControlFileDescriptorSupplier() {}
  }

  private static final class ControlMethodDescriptorSupplier
      extends ControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ControlMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ControlFileDescriptorSupplier())
              .addMethod(getStartMethod())
              .addMethod(getStopMethod())
              .addMethod(getFlushAggregationQueueMethod())
              .addMethod(getSetAggregatorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
