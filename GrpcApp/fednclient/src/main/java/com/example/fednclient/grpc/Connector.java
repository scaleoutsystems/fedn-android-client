// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fedn.proto

package com.example.fednclient.grpc;

/**
 * Protobuf service {@code grpc.Connector}
 */
public  abstract class Connector
    implements com.google.protobuf.Service {
  protected Connector() {}

  public interface Interface {
    /**
     * <pre>
     * Stream endpoint for status updates
     * </pre>
     *
     * <code>rpc AllianceStatusStream(.grpc.ClientAvailableMessage) returns (stream .grpc.Status);</code>
     */
    public abstract void allianceStatusStream(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ClientAvailableMessage request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Status> done);

    /**
     * <pre>
     * Report endpoint
     * </pre>
     *
     * <code>rpc SendStatus(.grpc.Status) returns (.grpc.Response);</code>
     */
    public abstract void sendStatus(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.Status request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done);

    /**
     * <pre>
     *    rpc RegisterClient (ClientAvailableMessage) returns (Response);
     * List active clients endpoint
     * </pre>
     *
     * <code>rpc ListActiveClients(.grpc.ListClientsRequest) returns (.grpc.ClientList);</code>
     */
    public abstract void listActiveClients(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ListClientsRequest request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.ClientList> done);

    /**
     * <code>rpc AcceptingClients(.grpc.ConnectionRequest) returns (.grpc.ConnectionResponse);</code>
     */
    public abstract void acceptingClients(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ConnectionRequest request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.ConnectionResponse> done);

    /**
     * <pre>
     * Client messaging to stay engaged.
     * </pre>
     *
     * <code>rpc SendHeartbeat(.grpc.Heartbeat) returns (.grpc.Response);</code>
     */
    public abstract void sendHeartbeat(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.Heartbeat request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done);

    /**
     * <code>rpc ReassignClient(.grpc.ReassignRequest) returns (.grpc.Response);</code>
     */
    public abstract void reassignClient(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ReassignRequest request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done);

    /**
     * <code>rpc ReconnectClient(.grpc.ReconnectRequest) returns (.grpc.Response);</code>
     */
    public abstract void reconnectClient(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ReconnectRequest request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done);

  }

  public static com.google.protobuf.Service newReflectiveService(
      final Interface impl) {
    return new Connector() {
      @java.lang.Override
      public  void allianceStatusStream(
          com.google.protobuf.RpcController controller,
          com.example.fednclient.grpc.ClientAvailableMessage request,
          com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Status> done) {
        impl.allianceStatusStream(controller, request, done);
      }

      @java.lang.Override
      public  void sendStatus(
          com.google.protobuf.RpcController controller,
          com.example.fednclient.grpc.Status request,
          com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done) {
        impl.sendStatus(controller, request, done);
      }

      @java.lang.Override
      public  void listActiveClients(
          com.google.protobuf.RpcController controller,
          com.example.fednclient.grpc.ListClientsRequest request,
          com.google.protobuf.RpcCallback<com.example.fednclient.grpc.ClientList> done) {
        impl.listActiveClients(controller, request, done);
      }

      @java.lang.Override
      public  void acceptingClients(
          com.google.protobuf.RpcController controller,
          com.example.fednclient.grpc.ConnectionRequest request,
          com.google.protobuf.RpcCallback<com.example.fednclient.grpc.ConnectionResponse> done) {
        impl.acceptingClients(controller, request, done);
      }

      @java.lang.Override
      public  void sendHeartbeat(
          com.google.protobuf.RpcController controller,
          com.example.fednclient.grpc.Heartbeat request,
          com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done) {
        impl.sendHeartbeat(controller, request, done);
      }

      @java.lang.Override
      public  void reassignClient(
          com.google.protobuf.RpcController controller,
          com.example.fednclient.grpc.ReassignRequest request,
          com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done) {
        impl.reassignClient(controller, request, done);
      }

      @java.lang.Override
      public  void reconnectClient(
          com.google.protobuf.RpcController controller,
          com.example.fednclient.grpc.ReconnectRequest request,
          com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done) {
        impl.reconnectClient(controller, request, done);
      }

    };
  }

  public static com.google.protobuf.BlockingService
      newReflectiveBlockingService(final BlockingInterface impl) {
    return new com.google.protobuf.BlockingService() {
      public final com.google.protobuf.Descriptors.ServiceDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }

      public final com.google.protobuf.Message callBlockingMethod(
          com.google.protobuf.Descriptors.MethodDescriptor method,
          com.google.protobuf.RpcController controller,
          com.google.protobuf.Message request)
          throws com.google.protobuf.ServiceException {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.callBlockingMethod() given method descriptor for " +
            "wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return impl.allianceStatusStream(controller, (com.example.fednclient.grpc.ClientAvailableMessage)request);
          case 1:
            return impl.sendStatus(controller, (com.example.fednclient.grpc.Status)request);
          case 2:
            return impl.listActiveClients(controller, (com.example.fednclient.grpc.ListClientsRequest)request);
          case 3:
            return impl.acceptingClients(controller, (com.example.fednclient.grpc.ConnectionRequest)request);
          case 4:
            return impl.sendHeartbeat(controller, (com.example.fednclient.grpc.Heartbeat)request);
          case 5:
            return impl.reassignClient(controller, (com.example.fednclient.grpc.ReassignRequest)request);
          case 6:
            return impl.reconnectClient(controller, (com.example.fednclient.grpc.ReconnectRequest)request);
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getRequestPrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getRequestPrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return com.example.fednclient.grpc.ClientAvailableMessage.getDefaultInstance();
          case 1:
            return com.example.fednclient.grpc.Status.getDefaultInstance();
          case 2:
            return com.example.fednclient.grpc.ListClientsRequest.getDefaultInstance();
          case 3:
            return com.example.fednclient.grpc.ConnectionRequest.getDefaultInstance();
          case 4:
            return com.example.fednclient.grpc.Heartbeat.getDefaultInstance();
          case 5:
            return com.example.fednclient.grpc.ReassignRequest.getDefaultInstance();
          case 6:
            return com.example.fednclient.grpc.ReconnectRequest.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getResponsePrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getResponsePrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return com.example.fednclient.grpc.Status.getDefaultInstance();
          case 1:
            return com.example.fednclient.grpc.Response.getDefaultInstance();
          case 2:
            return com.example.fednclient.grpc.ClientList.getDefaultInstance();
          case 3:
            return com.example.fednclient.grpc.ConnectionResponse.getDefaultInstance();
          case 4:
            return com.example.fednclient.grpc.Response.getDefaultInstance();
          case 5:
            return com.example.fednclient.grpc.Response.getDefaultInstance();
          case 6:
            return com.example.fednclient.grpc.Response.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

    };
  }

  /**
   * <pre>
   * Stream endpoint for status updates
   * </pre>
   *
   * <code>rpc AllianceStatusStream(.grpc.ClientAvailableMessage) returns (stream .grpc.Status);</code>
   */
  public abstract void allianceStatusStream(
      com.google.protobuf.RpcController controller,
      com.example.fednclient.grpc.ClientAvailableMessage request,
      com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Status> done);

  /**
   * <pre>
   * Report endpoint
   * </pre>
   *
   * <code>rpc SendStatus(.grpc.Status) returns (.grpc.Response);</code>
   */
  public abstract void sendStatus(
      com.google.protobuf.RpcController controller,
      com.example.fednclient.grpc.Status request,
      com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done);

  /**
   * <pre>
   *    rpc RegisterClient (ClientAvailableMessage) returns (Response);
   * List active clients endpoint
   * </pre>
   *
   * <code>rpc ListActiveClients(.grpc.ListClientsRequest) returns (.grpc.ClientList);</code>
   */
  public abstract void listActiveClients(
      com.google.protobuf.RpcController controller,
      com.example.fednclient.grpc.ListClientsRequest request,
      com.google.protobuf.RpcCallback<com.example.fednclient.grpc.ClientList> done);

  /**
   * <code>rpc AcceptingClients(.grpc.ConnectionRequest) returns (.grpc.ConnectionResponse);</code>
   */
  public abstract void acceptingClients(
      com.google.protobuf.RpcController controller,
      com.example.fednclient.grpc.ConnectionRequest request,
      com.google.protobuf.RpcCallback<com.example.fednclient.grpc.ConnectionResponse> done);

  /**
   * <pre>
   * Client messaging to stay engaged.
   * </pre>
   *
   * <code>rpc SendHeartbeat(.grpc.Heartbeat) returns (.grpc.Response);</code>
   */
  public abstract void sendHeartbeat(
      com.google.protobuf.RpcController controller,
      com.example.fednclient.grpc.Heartbeat request,
      com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done);

  /**
   * <code>rpc ReassignClient(.grpc.ReassignRequest) returns (.grpc.Response);</code>
   */
  public abstract void reassignClient(
      com.google.protobuf.RpcController controller,
      com.example.fednclient.grpc.ReassignRequest request,
      com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done);

  /**
   * <code>rpc ReconnectClient(.grpc.ReconnectRequest) returns (.grpc.Response);</code>
   */
  public abstract void reconnectClient(
      com.google.protobuf.RpcController controller,
      com.example.fednclient.grpc.ReconnectRequest request,
      com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done);

  public static final
      com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptor() {
    return com.example.fednclient.grpc.Fedn.getDescriptor().getServices().get(3);
  }
  public final com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }

  public final void callMethod(
      com.google.protobuf.Descriptors.MethodDescriptor method,
      com.google.protobuf.RpcController controller,
      com.google.protobuf.Message request,
      com.google.protobuf.RpcCallback<
        com.google.protobuf.Message> done) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.callMethod() given method descriptor for wrong " +
        "service type.");
    }
    switch(method.getIndex()) {
      case 0:
        this.allianceStatusStream(controller, (com.example.fednclient.grpc.ClientAvailableMessage)request,
          com.google.protobuf.RpcUtil.<com.example.fednclient.grpc.Status>specializeCallback(
            done));
        return;
      case 1:
        this.sendStatus(controller, (com.example.fednclient.grpc.Status)request,
          com.google.protobuf.RpcUtil.<com.example.fednclient.grpc.Response>specializeCallback(
            done));
        return;
      case 2:
        this.listActiveClients(controller, (com.example.fednclient.grpc.ListClientsRequest)request,
          com.google.protobuf.RpcUtil.<com.example.fednclient.grpc.ClientList>specializeCallback(
            done));
        return;
      case 3:
        this.acceptingClients(controller, (com.example.fednclient.grpc.ConnectionRequest)request,
          com.google.protobuf.RpcUtil.<com.example.fednclient.grpc.ConnectionResponse>specializeCallback(
            done));
        return;
      case 4:
        this.sendHeartbeat(controller, (com.example.fednclient.grpc.Heartbeat)request,
          com.google.protobuf.RpcUtil.<com.example.fednclient.grpc.Response>specializeCallback(
            done));
        return;
      case 5:
        this.reassignClient(controller, (com.example.fednclient.grpc.ReassignRequest)request,
          com.google.protobuf.RpcUtil.<com.example.fednclient.grpc.Response>specializeCallback(
            done));
        return;
      case 6:
        this.reconnectClient(controller, (com.example.fednclient.grpc.ReconnectRequest)request,
          com.google.protobuf.RpcUtil.<com.example.fednclient.grpc.Response>specializeCallback(
            done));
        return;
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getRequestPrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getRequestPrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return com.example.fednclient.grpc.ClientAvailableMessage.getDefaultInstance();
      case 1:
        return com.example.fednclient.grpc.Status.getDefaultInstance();
      case 2:
        return com.example.fednclient.grpc.ListClientsRequest.getDefaultInstance();
      case 3:
        return com.example.fednclient.grpc.ConnectionRequest.getDefaultInstance();
      case 4:
        return com.example.fednclient.grpc.Heartbeat.getDefaultInstance();
      case 5:
        return com.example.fednclient.grpc.ReassignRequest.getDefaultInstance();
      case 6:
        return com.example.fednclient.grpc.ReconnectRequest.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getResponsePrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getResponsePrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return com.example.fednclient.grpc.Status.getDefaultInstance();
      case 1:
        return com.example.fednclient.grpc.Response.getDefaultInstance();
      case 2:
        return com.example.fednclient.grpc.ClientList.getDefaultInstance();
      case 3:
        return com.example.fednclient.grpc.ConnectionResponse.getDefaultInstance();
      case 4:
        return com.example.fednclient.grpc.Response.getDefaultInstance();
      case 5:
        return com.example.fednclient.grpc.Response.getDefaultInstance();
      case 6:
        return com.example.fednclient.grpc.Response.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public static Stub newStub(
      com.google.protobuf.RpcChannel channel) {
    return new Stub(channel);
  }

  public static final class Stub extends com.example.fednclient.grpc.Connector implements Interface {
    private Stub(com.google.protobuf.RpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.RpcChannel channel;

    public com.google.protobuf.RpcChannel getChannel() {
      return channel;
    }

    public  void allianceStatusStream(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ClientAvailableMessage request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Status> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        com.example.fednclient.grpc.Status.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          com.example.fednclient.grpc.Status.class,
          com.example.fednclient.grpc.Status.getDefaultInstance()));
    }

    public  void sendStatus(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.Status request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(1),
        controller,
        request,
        com.example.fednclient.grpc.Response.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          com.example.fednclient.grpc.Response.class,
          com.example.fednclient.grpc.Response.getDefaultInstance()));
    }

    public  void listActiveClients(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ListClientsRequest request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.ClientList> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(2),
        controller,
        request,
        com.example.fednclient.grpc.ClientList.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          com.example.fednclient.grpc.ClientList.class,
          com.example.fednclient.grpc.ClientList.getDefaultInstance()));
    }

    public  void acceptingClients(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ConnectionRequest request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.ConnectionResponse> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(3),
        controller,
        request,
        com.example.fednclient.grpc.ConnectionResponse.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          com.example.fednclient.grpc.ConnectionResponse.class,
          com.example.fednclient.grpc.ConnectionResponse.getDefaultInstance()));
    }

    public  void sendHeartbeat(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.Heartbeat request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(4),
        controller,
        request,
        com.example.fednclient.grpc.Response.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          com.example.fednclient.grpc.Response.class,
          com.example.fednclient.grpc.Response.getDefaultInstance()));
    }

    public  void reassignClient(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ReassignRequest request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(5),
        controller,
        request,
        com.example.fednclient.grpc.Response.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          com.example.fednclient.grpc.Response.class,
          com.example.fednclient.grpc.Response.getDefaultInstance()));
    }

    public  void reconnectClient(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ReconnectRequest request,
        com.google.protobuf.RpcCallback<com.example.fednclient.grpc.Response> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(6),
        controller,
        request,
        com.example.fednclient.grpc.Response.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          com.example.fednclient.grpc.Response.class,
          com.example.fednclient.grpc.Response.getDefaultInstance()));
    }
  }

  public static BlockingInterface newBlockingStub(
      com.google.protobuf.BlockingRpcChannel channel) {
    return new BlockingStub(channel);
  }

  public interface BlockingInterface {
    public com.example.fednclient.grpc.Status allianceStatusStream(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ClientAvailableMessage request)
        throws com.google.protobuf.ServiceException;

    public com.example.fednclient.grpc.Response sendStatus(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.Status request)
        throws com.google.protobuf.ServiceException;

    public com.example.fednclient.grpc.ClientList listActiveClients(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ListClientsRequest request)
        throws com.google.protobuf.ServiceException;

    public com.example.fednclient.grpc.ConnectionResponse acceptingClients(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ConnectionRequest request)
        throws com.google.protobuf.ServiceException;

    public com.example.fednclient.grpc.Response sendHeartbeat(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.Heartbeat request)
        throws com.google.protobuf.ServiceException;

    public com.example.fednclient.grpc.Response reassignClient(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ReassignRequest request)
        throws com.google.protobuf.ServiceException;

    public com.example.fednclient.grpc.Response reconnectClient(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ReconnectRequest request)
        throws com.google.protobuf.ServiceException;
  }

  private static final class BlockingStub implements BlockingInterface {
    private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.BlockingRpcChannel channel;

    public com.example.fednclient.grpc.Status allianceStatusStream(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ClientAvailableMessage request)
        throws com.google.protobuf.ServiceException {
      return (com.example.fednclient.grpc.Status) channel.callBlockingMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        com.example.fednclient.grpc.Status.getDefaultInstance());
    }


    public com.example.fednclient.grpc.Response sendStatus(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.Status request)
        throws com.google.protobuf.ServiceException {
      return (com.example.fednclient.grpc.Response) channel.callBlockingMethod(
        getDescriptor().getMethods().get(1),
        controller,
        request,
        com.example.fednclient.grpc.Response.getDefaultInstance());
    }


    public com.example.fednclient.grpc.ClientList listActiveClients(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ListClientsRequest request)
        throws com.google.protobuf.ServiceException {
      return (com.example.fednclient.grpc.ClientList) channel.callBlockingMethod(
        getDescriptor().getMethods().get(2),
        controller,
        request,
        com.example.fednclient.grpc.ClientList.getDefaultInstance());
    }


    public com.example.fednclient.grpc.ConnectionResponse acceptingClients(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ConnectionRequest request)
        throws com.google.protobuf.ServiceException {
      return (com.example.fednclient.grpc.ConnectionResponse) channel.callBlockingMethod(
        getDescriptor().getMethods().get(3),
        controller,
        request,
        com.example.fednclient.grpc.ConnectionResponse.getDefaultInstance());
    }


    public com.example.fednclient.grpc.Response sendHeartbeat(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.Heartbeat request)
        throws com.google.protobuf.ServiceException {
      return (com.example.fednclient.grpc.Response) channel.callBlockingMethod(
        getDescriptor().getMethods().get(4),
        controller,
        request,
        com.example.fednclient.grpc.Response.getDefaultInstance());
    }


    public com.example.fednclient.grpc.Response reassignClient(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ReassignRequest request)
        throws com.google.protobuf.ServiceException {
      return (com.example.fednclient.grpc.Response) channel.callBlockingMethod(
        getDescriptor().getMethods().get(5),
        controller,
        request,
        com.example.fednclient.grpc.Response.getDefaultInstance());
    }


    public com.example.fednclient.grpc.Response reconnectClient(
        com.google.protobuf.RpcController controller,
        com.example.fednclient.grpc.ReconnectRequest request)
        throws com.google.protobuf.ServiceException {
      return (com.example.fednclient.grpc.Response) channel.callBlockingMethod(
        getDescriptor().getMethods().get(6),
        controller,
        request,
        com.example.fednclient.grpc.Response.getDefaultInstance());
    }

  }

  // @@protoc_insertion_point(class_scope:grpc.Connector)
}

