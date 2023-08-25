package com.example.fednclient.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: fedn.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ControlGrpc {

  private ControlGrpc() {}

  public static final java.lang.String SERVICE_NAME = "grpc.Control";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest,
      com.example.fednclient.grpc.ControlResponse> getStartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Start",
      requestType = com.example.fednclient.grpc.ControlRequest.class,
      responseType = com.example.fednclient.grpc.ControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest,
      com.example.fednclient.grpc.ControlResponse> getStartMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest, com.example.fednclient.grpc.ControlResponse> getStartMethod;
    if ((getStartMethod = ControlGrpc.getStartMethod) == null) {
      synchronized (ControlGrpc.class) {
        if ((getStartMethod = ControlGrpc.getStartMethod) == null) {
          ControlGrpc.getStartMethod = getStartMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.ControlRequest, com.example.fednclient.grpc.ControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Start"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ControlMethodDescriptorSupplier("Start"))
              .build();
        }
      }
    }
    return getStartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest,
      com.example.fednclient.grpc.ControlResponse> getStopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Stop",
      requestType = com.example.fednclient.grpc.ControlRequest.class,
      responseType = com.example.fednclient.grpc.ControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest,
      com.example.fednclient.grpc.ControlResponse> getStopMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest, com.example.fednclient.grpc.ControlResponse> getStopMethod;
    if ((getStopMethod = ControlGrpc.getStopMethod) == null) {
      synchronized (ControlGrpc.class) {
        if ((getStopMethod = ControlGrpc.getStopMethod) == null) {
          ControlGrpc.getStopMethod = getStopMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.ControlRequest, com.example.fednclient.grpc.ControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Stop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ControlMethodDescriptorSupplier("Stop"))
              .build();
        }
      }
    }
    return getStopMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest,
      com.example.fednclient.grpc.ReportResponse> getConfigureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Configure",
      requestType = com.example.fednclient.grpc.ControlRequest.class,
      responseType = com.example.fednclient.grpc.ReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest,
      com.example.fednclient.grpc.ReportResponse> getConfigureMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest, com.example.fednclient.grpc.ReportResponse> getConfigureMethod;
    if ((getConfigureMethod = ControlGrpc.getConfigureMethod) == null) {
      synchronized (ControlGrpc.class) {
        if ((getConfigureMethod = ControlGrpc.getConfigureMethod) == null) {
          ControlGrpc.getConfigureMethod = getConfigureMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.ControlRequest, com.example.fednclient.grpc.ReportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Configure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ReportResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ControlMethodDescriptorSupplier("Configure"))
              .build();
        }
      }
    }
    return getConfigureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest,
      com.example.fednclient.grpc.ReportResponse> getReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Report",
      requestType = com.example.fednclient.grpc.ControlRequest.class,
      responseType = com.example.fednclient.grpc.ReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest,
      com.example.fednclient.grpc.ReportResponse> getReportMethod() {
    io.grpc.MethodDescriptor<com.example.fednclient.grpc.ControlRequest, com.example.fednclient.grpc.ReportResponse> getReportMethod;
    if ((getReportMethod = ControlGrpc.getReportMethod) == null) {
      synchronized (ControlGrpc.class) {
        if ((getReportMethod = ControlGrpc.getReportMethod) == null) {
          ControlGrpc.getReportMethod = getReportMethod =
              io.grpc.MethodDescriptor.<com.example.fednclient.grpc.ControlRequest, com.example.fednclient.grpc.ReportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Report"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.fednclient.grpc.ReportResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ControlMethodDescriptorSupplier("Report"))
              .build();
        }
      }
    }
    return getReportMethod;
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
    default void start(com.example.fednclient.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartMethod(), responseObserver);
    }

    /**
     */
    default void stop(com.example.fednclient.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopMethod(), responseObserver);
    }

    /**
     */
    default void configure(com.example.fednclient.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ReportResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getConfigureMethod(), responseObserver);
    }

    /**
     */
    default void report(com.example.fednclient.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ReportResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReportMethod(), responseObserver);
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
    public void start(com.example.fednclient.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stop(com.example.fednclient.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void configure(com.example.fednclient.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ReportResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConfigureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void report(com.example.fednclient.grpc.ControlRequest request,
        io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ReportResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportMethod(), getCallOptions()), request, responseObserver);
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
    public com.example.fednclient.grpc.ControlResponse start(com.example.fednclient.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fednclient.grpc.ControlResponse stop(com.example.fednclient.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fednclient.grpc.ReportResponse configure(com.example.fednclient.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConfigureMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.fednclient.grpc.ReportResponse report(com.example.fednclient.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.example.fednclient.grpc.ControlResponse> start(
        com.example.fednclient.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fednclient.grpc.ControlResponse> stop(
        com.example.fednclient.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fednclient.grpc.ReportResponse> configure(
        com.example.fednclient.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConfigureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.fednclient.grpc.ReportResponse> report(
        com.example.fednclient.grpc.ControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START = 0;
  private static final int METHODID_STOP = 1;
  private static final int METHODID_CONFIGURE = 2;
  private static final int METHODID_REPORT = 3;

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
          serviceImpl.start((com.example.fednclient.grpc.ControlRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ControlResponse>) responseObserver);
          break;
        case METHODID_STOP:
          serviceImpl.stop((com.example.fednclient.grpc.ControlRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ControlResponse>) responseObserver);
          break;
        case METHODID_CONFIGURE:
          serviceImpl.configure((com.example.fednclient.grpc.ControlRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ReportResponse>) responseObserver);
          break;
        case METHODID_REPORT:
          serviceImpl.report((com.example.fednclient.grpc.ControlRequest) request,
              (io.grpc.stub.StreamObserver<com.example.fednclient.grpc.ReportResponse>) responseObserver);
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
              com.example.fednclient.grpc.ControlRequest,
              com.example.fednclient.grpc.ControlResponse>(
                service, METHODID_START)))
        .addMethod(
          getStopMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fednclient.grpc.ControlRequest,
              com.example.fednclient.grpc.ControlResponse>(
                service, METHODID_STOP)))
        .addMethod(
          getConfigureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fednclient.grpc.ControlRequest,
              com.example.fednclient.grpc.ReportResponse>(
                service, METHODID_CONFIGURE)))
        .addMethod(
          getReportMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.fednclient.grpc.ControlRequest,
              com.example.fednclient.grpc.ReportResponse>(
                service, METHODID_REPORT)))
        .build();
  }

  private static abstract class ControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.fednclient.grpc.Fedn.getDescriptor();
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
              .addMethod(getConfigureMethod())
              .addMethod(getReportMethod())
              .build();
        }
      }
    }
    return result;
  }
}
