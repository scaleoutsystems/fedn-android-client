package com.example.fedn_client.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: fedn.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CombinerGrpc {

  private CombinerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.fedn_client.grpc.Combiner";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage,
      com.example.fedn_client.grpc.TaskRequest> getTaskStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TaskStream",
      requestType = com.example.fedn_client.grpc.ClientAvailableMessage.class,
      responseType = com.example.fedn_client.grpc.TaskRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage,
      com.example.fedn_client.grpc.TaskRequest> getTaskStreamMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage, com.example.fedn_client.grpc.TaskRequest> getTaskStreamMethod;
    if ((getTaskStreamMethod = CombinerGrpc.getTaskStreamMethod) == null) {
      synchronized (CombinerGrpc.class) {
        if ((getTaskStreamMethod = CombinerGrpc.getTaskStreamMethod) == null) {
          CombinerGrpc.getTaskStreamMethod = getTaskStreamMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ClientAvailableMessage, com.example.fedn_client.grpc.TaskRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TaskStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ClientAvailableMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.TaskRequest.getDefaultInstance()))
              .setSchemaDescriptor(new CombinerMethodDescriptorSupplier("TaskStream"))
              .build();
        }
      }
    }
    return getTaskStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelUpdate,
      com.example.fedn_client.grpc.Response> getSendModelUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendModelUpdate",
      requestType = com.example.fedn_client.grpc.ModelUpdate.class,
      responseType = com.example.fedn_client.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelUpdate,
      com.example.fedn_client.grpc.Response> getSendModelUpdateMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelUpdate, com.example.fedn_client.grpc.Response> getSendModelUpdateMethod;
    if ((getSendModelUpdateMethod = CombinerGrpc.getSendModelUpdateMethod) == null) {
      synchronized (CombinerGrpc.class) {
        if ((getSendModelUpdateMethod = CombinerGrpc.getSendModelUpdateMethod) == null) {
          CombinerGrpc.getSendModelUpdateMethod = getSendModelUpdateMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ModelUpdate, com.example.fedn_client.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendModelUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ModelUpdate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new CombinerMethodDescriptorSupplier("SendModelUpdate"))
              .build();
        }
      }
    }
    return getSendModelUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelValidation,
      com.example.fedn_client.grpc.Response> getSendModelValidationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendModelValidation",
      requestType = com.example.fedn_client.grpc.ModelValidation.class,
      responseType = com.example.fedn_client.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelValidation,
      com.example.fedn_client.grpc.Response> getSendModelValidationMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelValidation, com.example.fedn_client.grpc.Response> getSendModelValidationMethod;
    if ((getSendModelValidationMethod = CombinerGrpc.getSendModelValidationMethod) == null) {
      synchronized (CombinerGrpc.class) {
        if ((getSendModelValidationMethod = CombinerGrpc.getSendModelValidationMethod) == null) {
          CombinerGrpc.getSendModelValidationMethod = getSendModelValidationMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ModelValidation, com.example.fedn_client.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendModelValidation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ModelValidation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new CombinerMethodDescriptorSupplier("SendModelValidation"))
              .build();
        }
      }
    }
    return getSendModelValidationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CombinerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CombinerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CombinerStub>() {
        @java.lang.Override
        public CombinerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CombinerStub(channel, callOptions);
        }
      };
    return CombinerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CombinerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CombinerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CombinerBlockingStub>() {
        @java.lang.Override
        public CombinerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CombinerBlockingStub(channel, callOptions);
        }
      };
    return CombinerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CombinerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CombinerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CombinerFutureStub>() {
        @java.lang.Override
        public CombinerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CombinerFutureStub(channel, callOptions);
        }
      };
    return CombinerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Stream endpoints for training/validation pub/sub
     * </pre>
     */
    default void taskStream(com.example.fedn_client.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.TaskRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTaskStreamMethod(), responseObserver);
    }

    /**
     */
    default void sendModelUpdate(com.example.fedn_client.grpc.ModelUpdate request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendModelUpdateMethod(), responseObserver);
    }

    /**
     */
    default void sendModelValidation(com.example.fedn_client.grpc.ModelValidation request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendModelValidationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Combiner.
   */
  public static abstract class CombinerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CombinerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Combiner.
   */
  public static final class CombinerStub
      extends io.grpc.stub.AbstractAsyncStub<CombinerStub> {
    private CombinerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CombinerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CombinerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Stream endpoints for training/validation pub/sub
     * </pre>
     */
    public void taskStream(com.example.fedn_client.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.TaskRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getTaskStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendModelUpdate(com.example.fedn_client.grpc.ModelUpdate request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendModelUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendModelValidation(com.example.fedn_client.grpc.ModelValidation request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendModelValidationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Combiner.
   */
  public static final class CombinerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CombinerBlockingStub> {
    private CombinerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CombinerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CombinerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Stream endpoints for training/validation pub/sub
     * </pre>
     */
    public java.util.Iterator<com.example.fedn_client.grpc.TaskRequest> taskStream(
        com.example.fedn_client.grpc.ClientAvailableMessage request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getTaskStreamMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fedn_client.grpc.Response sendModelUpdate(com.example.fedn_client.grpc.ModelUpdate request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendModelUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fedn_client.grpc.Response sendModelValidation(com.example.fedn_client.grpc.ModelValidation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendModelValidationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Combiner.
   */
  public static final class CombinerFutureStub
      extends io.grpc.stub.AbstractFutureStub<CombinerFutureStub> {
    private CombinerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CombinerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CombinerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fedn_client.grpc.Response> sendModelUpdate(
        com.example.fedn_client.grpc.ModelUpdate request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendModelUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fedn_client.grpc.Response> sendModelValidation(
        com.example.fedn_client.grpc.ModelValidation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendModelValidationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TASK_STREAM = 0;
  private static final int METHODID_SEND_MODEL_UPDATE = 1;
  private static final int METHODID_SEND_MODEL_VALIDATION = 2;

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
        case METHODID_TASK_STREAM:
          serviceImpl.taskStream((com.example.fedn_client.grpc.ClientAvailableMessage) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.TaskRequest>) responseObserver);
          break;
        case METHODID_SEND_MODEL_UPDATE:
          serviceImpl.sendModelUpdate((com.example.fedn_client.grpc.ModelUpdate) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response>) responseObserver);
          break;
        case METHODID_SEND_MODEL_VALIDATION:
          serviceImpl.sendModelValidation((com.example.fedn_client.grpc.ModelValidation) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response>) responseObserver);
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
          getTaskStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ClientAvailableMessage,
              com.example.fedn_client.grpc.TaskRequest>(
                service, METHODID_TASK_STREAM)))
        .addMethod(
          getSendModelUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ModelUpdate,
              com.example.fedn_client.grpc.Response>(
                service, METHODID_SEND_MODEL_UPDATE)))
        .addMethod(
          getSendModelValidationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ModelValidation,
              com.example.fedn_client.grpc.Response>(
                service, METHODID_SEND_MODEL_VALIDATION)))
        .build();
  }

  private static abstract class CombinerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CombinerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.fedn_client.grpc.Fedn.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Combiner");
    }
  }

  private static final class CombinerFileDescriptorSupplier
      extends CombinerBaseDescriptorSupplier {
    CombinerFileDescriptorSupplier() {}
  }

  private static final class CombinerMethodDescriptorSupplier
      extends CombinerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CombinerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CombinerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CombinerFileDescriptorSupplier())
              .addMethod(getTaskStreamMethod())
              .addMethod(getSendModelUpdateMethod())
              .addMethod(getSendModelValidationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
