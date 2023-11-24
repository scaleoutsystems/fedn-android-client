package com.example.fedn_client.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: fedn.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReducerGrpc {

  private ReducerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "grpc.Reducer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.GetGlobalModelRequest,
      com.example.fedn_client.grpc.GetGlobalModelResponse> getGetGlobalModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGlobalModel",
      requestType = com.example.fedn_client.grpc.GetGlobalModelRequest.class,
      responseType = com.example.fedn_client.grpc.GetGlobalModelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.GetGlobalModelRequest,
      com.example.fedn_client.grpc.GetGlobalModelResponse> getGetGlobalModelMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.GetGlobalModelRequest, com.example.fedn_client.grpc.GetGlobalModelResponse> getGetGlobalModelMethod;
    if ((getGetGlobalModelMethod = ReducerGrpc.getGetGlobalModelMethod) == null) {
      synchronized (ReducerGrpc.class) {
        if ((getGetGlobalModelMethod = ReducerGrpc.getGetGlobalModelMethod) == null) {
          ReducerGrpc.getGetGlobalModelMethod = getGetGlobalModelMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.GetGlobalModelRequest, com.example.fedn_client.grpc.GetGlobalModelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGlobalModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.GetGlobalModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.GetGlobalModelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReducerMethodDescriptorSupplier("GetGlobalModel"))
              .build();
        }
      }
    }
    return getGetGlobalModelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReducerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReducerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReducerStub>() {
        @java.lang.Override
        public ReducerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReducerStub(channel, callOptions);
        }
      };
    return ReducerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReducerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReducerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReducerBlockingStub>() {
        @java.lang.Override
        public ReducerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReducerBlockingStub(channel, callOptions);
        }
      };
    return ReducerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReducerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReducerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReducerFutureStub>() {
        @java.lang.Override
        public ReducerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReducerFutureStub(channel, callOptions);
        }
      };
    return ReducerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getGlobalModel(com.example.fedn_client.grpc.GetGlobalModelRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.GetGlobalModelResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGlobalModelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Reducer.
   */
  public static abstract class ReducerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ReducerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Reducer.
   */
  public static final class ReducerStub
      extends io.grpc.stub.AbstractAsyncStub<ReducerStub> {
    private ReducerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReducerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReducerStub(channel, callOptions);
    }

    /**
     */
    public void getGlobalModel(com.example.fedn_client.grpc.GetGlobalModelRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.GetGlobalModelResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGlobalModelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Reducer.
   */
  public static final class ReducerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReducerBlockingStub> {
    private ReducerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReducerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReducerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.fedn_client.grpc.GetGlobalModelResponse getGlobalModel(com.example.fedn_client.grpc.GetGlobalModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGlobalModelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Reducer.
   */
  public static final class ReducerFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReducerFutureStub> {
    private ReducerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReducerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReducerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fedn_client.grpc.GetGlobalModelResponse> getGlobalModel(
        com.example.fedn_client.grpc.GetGlobalModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGlobalModelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_GLOBAL_MODEL = 0;

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
        case METHODID_GET_GLOBAL_MODEL:
          serviceImpl.getGlobalModel((com.example.fedn_client.grpc.GetGlobalModelRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.GetGlobalModelResponse>) responseObserver);
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
          getGetGlobalModelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.GetGlobalModelRequest,
              com.example.fedn_client.grpc.GetGlobalModelResponse>(
                service, METHODID_GET_GLOBAL_MODEL)))
        .build();
  }

  private static abstract class ReducerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReducerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.fedn_client.grpc.Fedn.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Reducer");
    }
  }

  private static final class ReducerFileDescriptorSupplier
      extends ReducerBaseDescriptorSupplier {
    ReducerFileDescriptorSupplier() {}
  }

  private static final class ReducerMethodDescriptorSupplier
      extends ReducerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReducerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ReducerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReducerFileDescriptorSupplier())
              .addMethod(getGetGlobalModelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
