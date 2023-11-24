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

  public static final java.lang.String SERVICE_NAME = "grpc.Combiner";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage,
      com.example.fedn_client.grpc.ModelUpdateRequest> getModelUpdateRequestStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModelUpdateRequestStream",
      requestType = com.example.fedn_client.grpc.ClientAvailableMessage.class,
      responseType = com.example.fedn_client.grpc.ModelUpdateRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage,
      com.example.fedn_client.grpc.ModelUpdateRequest> getModelUpdateRequestStreamMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage, com.example.fedn_client.grpc.ModelUpdateRequest> getModelUpdateRequestStreamMethod;
    if ((getModelUpdateRequestStreamMethod = CombinerGrpc.getModelUpdateRequestStreamMethod) == null) {
      synchronized (CombinerGrpc.class) {
        if ((getModelUpdateRequestStreamMethod = CombinerGrpc.getModelUpdateRequestStreamMethod) == null) {
          CombinerGrpc.getModelUpdateRequestStreamMethod = getModelUpdateRequestStreamMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ClientAvailableMessage, com.example.fedn_client.grpc.ModelUpdateRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModelUpdateRequestStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ClientAvailableMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ModelUpdateRequest.getDefaultInstance()))
              .setSchemaDescriptor(new CombinerMethodDescriptorSupplier("ModelUpdateRequestStream"))
              .build();
        }
      }
    }
    return getModelUpdateRequestStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage,
      com.example.fedn_client.grpc.ModelUpdate> getModelUpdateStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModelUpdateStream",
      requestType = com.example.fedn_client.grpc.ClientAvailableMessage.class,
      responseType = com.example.fedn_client.grpc.ModelUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage,
      com.example.fedn_client.grpc.ModelUpdate> getModelUpdateStreamMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage, com.example.fedn_client.grpc.ModelUpdate> getModelUpdateStreamMethod;
    if ((getModelUpdateStreamMethod = CombinerGrpc.getModelUpdateStreamMethod) == null) {
      synchronized (CombinerGrpc.class) {
        if ((getModelUpdateStreamMethod = CombinerGrpc.getModelUpdateStreamMethod) == null) {
          CombinerGrpc.getModelUpdateStreamMethod = getModelUpdateStreamMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ClientAvailableMessage, com.example.fedn_client.grpc.ModelUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModelUpdateStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ClientAvailableMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ModelUpdate.getDefaultInstance()))
              .setSchemaDescriptor(new CombinerMethodDescriptorSupplier("ModelUpdateStream"))
              .build();
        }
      }
    }
    return getModelUpdateStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage,
      com.example.fedn_client.grpc.ModelValidationRequest> getModelValidationRequestStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModelValidationRequestStream",
      requestType = com.example.fedn_client.grpc.ClientAvailableMessage.class,
      responseType = com.example.fedn_client.grpc.ModelValidationRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage,
      com.example.fedn_client.grpc.ModelValidationRequest> getModelValidationRequestStreamMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage, com.example.fedn_client.grpc.ModelValidationRequest> getModelValidationRequestStreamMethod;
    if ((getModelValidationRequestStreamMethod = CombinerGrpc.getModelValidationRequestStreamMethod) == null) {
      synchronized (CombinerGrpc.class) {
        if ((getModelValidationRequestStreamMethod = CombinerGrpc.getModelValidationRequestStreamMethod) == null) {
          CombinerGrpc.getModelValidationRequestStreamMethod = getModelValidationRequestStreamMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ClientAvailableMessage, com.example.fedn_client.grpc.ModelValidationRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModelValidationRequestStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ClientAvailableMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ModelValidationRequest.getDefaultInstance()))
              .setSchemaDescriptor(new CombinerMethodDescriptorSupplier("ModelValidationRequestStream"))
              .build();
        }
      }
    }
    return getModelValidationRequestStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage,
      com.example.fedn_client.grpc.ModelValidation> getModelValidationStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModelValidationStream",
      requestType = com.example.fedn_client.grpc.ClientAvailableMessage.class,
      responseType = com.example.fedn_client.grpc.ModelValidation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage,
      com.example.fedn_client.grpc.ModelValidation> getModelValidationStreamMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ClientAvailableMessage, com.example.fedn_client.grpc.ModelValidation> getModelValidationStreamMethod;
    if ((getModelValidationStreamMethod = CombinerGrpc.getModelValidationStreamMethod) == null) {
      synchronized (CombinerGrpc.class) {
        if ((getModelValidationStreamMethod = CombinerGrpc.getModelValidationStreamMethod) == null) {
          CombinerGrpc.getModelValidationStreamMethod = getModelValidationStreamMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ClientAvailableMessage, com.example.fedn_client.grpc.ModelValidation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModelValidationStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ClientAvailableMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ModelValidation.getDefaultInstance()))
              .setSchemaDescriptor(new CombinerMethodDescriptorSupplier("ModelValidationStream"))
              .build();
        }
      }
    }
    return getModelValidationStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelUpdateRequest,
      com.example.fedn_client.grpc.Response> getSendModelUpdateRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendModelUpdateRequest",
      requestType = com.example.fedn_client.grpc.ModelUpdateRequest.class,
      responseType = com.example.fedn_client.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelUpdateRequest,
      com.example.fedn_client.grpc.Response> getSendModelUpdateRequestMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelUpdateRequest, com.example.fedn_client.grpc.Response> getSendModelUpdateRequestMethod;
    if ((getSendModelUpdateRequestMethod = CombinerGrpc.getSendModelUpdateRequestMethod) == null) {
      synchronized (CombinerGrpc.class) {
        if ((getSendModelUpdateRequestMethod = CombinerGrpc.getSendModelUpdateRequestMethod) == null) {
          CombinerGrpc.getSendModelUpdateRequestMethod = getSendModelUpdateRequestMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ModelUpdateRequest, com.example.fedn_client.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendModelUpdateRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ModelUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new CombinerMethodDescriptorSupplier("SendModelUpdateRequest"))
              .build();
        }
      }
    }
    return getSendModelUpdateRequestMethod;
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

  private static volatile io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelValidationRequest,
      com.example.fedn_client.grpc.Response> getSendModelValidationRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendModelValidationRequest",
      requestType = com.example.fedn_client.grpc.ModelValidationRequest.class,
      responseType = com.example.fedn_client.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelValidationRequest,
      com.example.fedn_client.grpc.Response> getSendModelValidationRequestMethod() {
    io.grpc.MethodDescriptor<com.example.fedn_client.grpc.ModelValidationRequest, com.example.fedn_client.grpc.Response> getSendModelValidationRequestMethod;
    if ((getSendModelValidationRequestMethod = CombinerGrpc.getSendModelValidationRequestMethod) == null) {
      synchronized (CombinerGrpc.class) {
        if ((getSendModelValidationRequestMethod = CombinerGrpc.getSendModelValidationRequestMethod) == null) {
          CombinerGrpc.getSendModelValidationRequestMethod = getSendModelValidationRequestMethod =
              io.grpc.MethodDescriptor.<com.example.fedn_client.grpc.ModelValidationRequest, com.example.fedn_client.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendModelValidationRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.ModelValidationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fedn_client.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new CombinerMethodDescriptorSupplier("SendModelValidationRequest"))
              .build();
        }
      }
    }
    return getSendModelValidationRequestMethod;
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
    default void modelUpdateRequestStream(com.example.fedn_client.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelUpdateRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModelUpdateRequestStreamMethod(), responseObserver);
    }

    /**
     */
    default void modelUpdateStream(com.example.fedn_client.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelUpdate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModelUpdateStreamMethod(), responseObserver);
    }

    /**
     */
    default void modelValidationRequestStream(com.example.fedn_client.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelValidationRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModelValidationRequestStreamMethod(), responseObserver);
    }

    /**
     */
    default void modelValidationStream(com.example.fedn_client.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelValidation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModelValidationStreamMethod(), responseObserver);
    }

    /**
     */
    default void sendModelUpdateRequest(com.example.fedn_client.grpc.ModelUpdateRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendModelUpdateRequestMethod(), responseObserver);
    }

    /**
     */
    default void sendModelUpdate(com.example.fedn_client.grpc.ModelUpdate request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendModelUpdateMethod(), responseObserver);
    }

    /**
     */
    default void sendModelValidationRequest(com.example.fedn_client.grpc.ModelValidationRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendModelValidationRequestMethod(), responseObserver);
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
    public void modelUpdateRequestStream(com.example.fedn_client.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelUpdateRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getModelUpdateRequestStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modelUpdateStream(com.example.fedn_client.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelUpdate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getModelUpdateStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modelValidationRequestStream(com.example.fedn_client.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelValidationRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getModelValidationRequestStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modelValidationStream(com.example.fedn_client.grpc.ClientAvailableMessage request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelValidation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getModelValidationStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendModelUpdateRequest(com.example.fedn_client.grpc.ModelUpdateRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendModelUpdateRequestMethod(), getCallOptions()), request, responseObserver);
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
    public void sendModelValidationRequest(com.example.fedn_client.grpc.ModelValidationRequest request,
        io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendModelValidationRequestMethod(), getCallOptions()), request, responseObserver);
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
    public java.util.Iterator<com.example.fedn_client.grpc.ModelUpdateRequest> modelUpdateRequestStream(
        com.example.fedn_client.grpc.ClientAvailableMessage request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getModelUpdateRequestStreamMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.fedn_client.grpc.ModelUpdate> modelUpdateStream(
        com.example.fedn_client.grpc.ClientAvailableMessage request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getModelUpdateStreamMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.fedn_client.grpc.ModelValidationRequest> modelValidationRequestStream(
        com.example.fedn_client.grpc.ClientAvailableMessage request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getModelValidationRequestStreamMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.fedn_client.grpc.ModelValidation> modelValidationStream(
        com.example.fedn_client.grpc.ClientAvailableMessage request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getModelValidationStreamMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fedn_client.grpc.Response sendModelUpdateRequest(com.example.fedn_client.grpc.ModelUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendModelUpdateRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fedn_client.grpc.Response sendModelUpdate(com.example.fedn_client.grpc.ModelUpdate request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendModelUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fedn_client.grpc.Response sendModelValidationRequest(com.example.fedn_client.grpc.ModelValidationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendModelValidationRequestMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.example.fedn_client.grpc.Response> sendModelUpdateRequest(
        com.example.fedn_client.grpc.ModelUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendModelUpdateRequestMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.example.fedn_client.grpc.Response> sendModelValidationRequest(
        com.example.fedn_client.grpc.ModelValidationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendModelValidationRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fedn_client.grpc.Response> sendModelValidation(
        com.example.fedn_client.grpc.ModelValidation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendModelValidationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MODEL_UPDATE_REQUEST_STREAM = 0;
  private static final int METHODID_MODEL_UPDATE_STREAM = 1;
  private static final int METHODID_MODEL_VALIDATION_REQUEST_STREAM = 2;
  private static final int METHODID_MODEL_VALIDATION_STREAM = 3;
  private static final int METHODID_SEND_MODEL_UPDATE_REQUEST = 4;
  private static final int METHODID_SEND_MODEL_UPDATE = 5;
  private static final int METHODID_SEND_MODEL_VALIDATION_REQUEST = 6;
  private static final int METHODID_SEND_MODEL_VALIDATION = 7;

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
        case METHODID_MODEL_UPDATE_REQUEST_STREAM:
          serviceImpl.modelUpdateRequestStream((com.example.fedn_client.grpc.ClientAvailableMessage) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelUpdateRequest>) responseObserver);
          break;
        case METHODID_MODEL_UPDATE_STREAM:
          serviceImpl.modelUpdateStream((com.example.fedn_client.grpc.ClientAvailableMessage) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelUpdate>) responseObserver);
          break;
        case METHODID_MODEL_VALIDATION_REQUEST_STREAM:
          serviceImpl.modelValidationRequestStream((com.example.fedn_client.grpc.ClientAvailableMessage) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelValidationRequest>) responseObserver);
          break;
        case METHODID_MODEL_VALIDATION_STREAM:
          serviceImpl.modelValidationStream((com.example.fedn_client.grpc.ClientAvailableMessage) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.ModelValidation>) responseObserver);
          break;
        case METHODID_SEND_MODEL_UPDATE_REQUEST:
          serviceImpl.sendModelUpdateRequest((com.example.fedn_client.grpc.ModelUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response>) responseObserver);
          break;
        case METHODID_SEND_MODEL_UPDATE:
          serviceImpl.sendModelUpdate((com.example.fedn_client.grpc.ModelUpdate) request,
              (io.grpc.stub.StreamObserver<com.example.fedn_client.grpc.Response>) responseObserver);
          break;
        case METHODID_SEND_MODEL_VALIDATION_REQUEST:
          serviceImpl.sendModelValidationRequest((com.example.fedn_client.grpc.ModelValidationRequest) request,
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
          getModelUpdateRequestStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ClientAvailableMessage,
              com.example.fedn_client.grpc.ModelUpdateRequest>(
                service, METHODID_MODEL_UPDATE_REQUEST_STREAM)))
        .addMethod(
          getModelUpdateStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ClientAvailableMessage,
              com.example.fedn_client.grpc.ModelUpdate>(
                service, METHODID_MODEL_UPDATE_STREAM)))
        .addMethod(
          getModelValidationRequestStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ClientAvailableMessage,
              com.example.fedn_client.grpc.ModelValidationRequest>(
                service, METHODID_MODEL_VALIDATION_REQUEST_STREAM)))
        .addMethod(
          getModelValidationStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ClientAvailableMessage,
              com.example.fedn_client.grpc.ModelValidation>(
                service, METHODID_MODEL_VALIDATION_STREAM)))
        .addMethod(
          getSendModelUpdateRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ModelUpdateRequest,
              com.example.fedn_client.grpc.Response>(
                service, METHODID_SEND_MODEL_UPDATE_REQUEST)))
        .addMethod(
          getSendModelUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ModelUpdate,
              com.example.fedn_client.grpc.Response>(
                service, METHODID_SEND_MODEL_UPDATE)))
        .addMethod(
          getSendModelValidationRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fedn_client.grpc.ModelValidationRequest,
              com.example.fedn_client.grpc.Response>(
                service, METHODID_SEND_MODEL_VALIDATION_REQUEST)))
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
              .addMethod(getModelUpdateRequestStreamMethod())
              .addMethod(getModelUpdateStreamMethod())
              .addMethod(getModelValidationRequestStreamMethod())
              .addMethod(getModelValidationStreamMethod())
              .addMethod(getSendModelUpdateRequestMethod())
              .addMethod(getSendModelUpdateMethod())
              .addMethod(getSendModelValidationRequestMethod())
              .addMethod(getSendModelValidationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
