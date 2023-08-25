// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fedn.proto

package com.example.fednclient.grpc;

/**
 * Protobuf type {@code grpc.ReassignRequest}
 */
public final class ReassignRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.ReassignRequest)
    ReassignRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ReassignRequest.newBuilder() to construct.
  private ReassignRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ReassignRequest() {
    server_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ReassignRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.fednclient.grpc.Fedn.internal_static_grpc_ReassignRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.fednclient.grpc.Fedn.internal_static_grpc_ReassignRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.fednclient.grpc.ReassignRequest.class, com.example.fednclient.grpc.ReassignRequest.Builder.class);
  }

  public static final int SENDER_FIELD_NUMBER = 1;
  private com.example.fednclient.grpc.Client sender_;
  /**
   * <code>.grpc.Client sender = 1;</code>
   * @return Whether the sender field is set.
   */
  @java.lang.Override
  public boolean hasSender() {
    return sender_ != null;
  }
  /**
   * <code>.grpc.Client sender = 1;</code>
   * @return The sender.
   */
  @java.lang.Override
  public com.example.fednclient.grpc.Client getSender() {
    return sender_ == null ? com.example.fednclient.grpc.Client.getDefaultInstance() : sender_;
  }
  /**
   * <code>.grpc.Client sender = 1;</code>
   */
  @java.lang.Override
  public com.example.fednclient.grpc.ClientOrBuilder getSenderOrBuilder() {
    return sender_ == null ? com.example.fednclient.grpc.Client.getDefaultInstance() : sender_;
  }

  public static final int RECEIVER_FIELD_NUMBER = 2;
  private com.example.fednclient.grpc.Client receiver_;
  /**
   * <code>.grpc.Client receiver = 2;</code>
   * @return Whether the receiver field is set.
   */
  @java.lang.Override
  public boolean hasReceiver() {
    return receiver_ != null;
  }
  /**
   * <code>.grpc.Client receiver = 2;</code>
   * @return The receiver.
   */
  @java.lang.Override
  public com.example.fednclient.grpc.Client getReceiver() {
    return receiver_ == null ? com.example.fednclient.grpc.Client.getDefaultInstance() : receiver_;
  }
  /**
   * <code>.grpc.Client receiver = 2;</code>
   */
  @java.lang.Override
  public com.example.fednclient.grpc.ClientOrBuilder getReceiverOrBuilder() {
    return receiver_ == null ? com.example.fednclient.grpc.Client.getDefaultInstance() : receiver_;
  }

  public static final int SERVER_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object server_ = "";
  /**
   * <code>string server = 3;</code>
   * @return The server.
   */
  @java.lang.Override
  public java.lang.String getServer() {
    java.lang.Object ref = server_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      server_ = s;
      return s;
    }
  }
  /**
   * <code>string server = 3;</code>
   * @return The bytes for server.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getServerBytes() {
    java.lang.Object ref = server_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      server_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PORT_FIELD_NUMBER = 4;
  private int port_ = 0;
  /**
   * <code>uint32 port = 4;</code>
   * @return The port.
   */
  @java.lang.Override
  public int getPort() {
    return port_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (sender_ != null) {
      output.writeMessage(1, getSender());
    }
    if (receiver_ != null) {
      output.writeMessage(2, getReceiver());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(server_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, server_);
    }
    if (port_ != 0) {
      output.writeUInt32(4, port_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (sender_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getSender());
    }
    if (receiver_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getReceiver());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(server_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, server_);
    }
    if (port_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(4, port_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.fednclient.grpc.ReassignRequest)) {
      return super.equals(obj);
    }
    com.example.fednclient.grpc.ReassignRequest other = (com.example.fednclient.grpc.ReassignRequest) obj;

    if (hasSender() != other.hasSender()) return false;
    if (hasSender()) {
      if (!getSender()
          .equals(other.getSender())) return false;
    }
    if (hasReceiver() != other.hasReceiver()) return false;
    if (hasReceiver()) {
      if (!getReceiver()
          .equals(other.getReceiver())) return false;
    }
    if (!getServer()
        .equals(other.getServer())) return false;
    if (getPort()
        != other.getPort()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasSender()) {
      hash = (37 * hash) + SENDER_FIELD_NUMBER;
      hash = (53 * hash) + getSender().hashCode();
    }
    if (hasReceiver()) {
      hash = (37 * hash) + RECEIVER_FIELD_NUMBER;
      hash = (53 * hash) + getReceiver().hashCode();
    }
    hash = (37 * hash) + SERVER_FIELD_NUMBER;
    hash = (53 * hash) + getServer().hashCode();
    hash = (37 * hash) + PORT_FIELD_NUMBER;
    hash = (53 * hash) + getPort();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.fednclient.grpc.ReassignRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.fednclient.grpc.ReassignRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.fednclient.grpc.ReassignRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.fednclient.grpc.ReassignRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.fednclient.grpc.ReassignRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.fednclient.grpc.ReassignRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.fednclient.grpc.ReassignRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.fednclient.grpc.ReassignRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.example.fednclient.grpc.ReassignRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.example.fednclient.grpc.ReassignRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.fednclient.grpc.ReassignRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.fednclient.grpc.ReassignRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.fednclient.grpc.ReassignRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpc.ReassignRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.ReassignRequest)
      com.example.fednclient.grpc.ReassignRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.fednclient.grpc.Fedn.internal_static_grpc_ReassignRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.fednclient.grpc.Fedn.internal_static_grpc_ReassignRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.fednclient.grpc.ReassignRequest.class, com.example.fednclient.grpc.ReassignRequest.Builder.class);
    }

    // Construct using com.example.fednclient.grpc.ReassignRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      sender_ = null;
      if (senderBuilder_ != null) {
        senderBuilder_.dispose();
        senderBuilder_ = null;
      }
      receiver_ = null;
      if (receiverBuilder_ != null) {
        receiverBuilder_.dispose();
        receiverBuilder_ = null;
      }
      server_ = "";
      port_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.fednclient.grpc.Fedn.internal_static_grpc_ReassignRequest_descriptor;
    }

    @java.lang.Override
    public com.example.fednclient.grpc.ReassignRequest getDefaultInstanceForType() {
      return com.example.fednclient.grpc.ReassignRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.fednclient.grpc.ReassignRequest build() {
      com.example.fednclient.grpc.ReassignRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.fednclient.grpc.ReassignRequest buildPartial() {
      com.example.fednclient.grpc.ReassignRequest result = new com.example.fednclient.grpc.ReassignRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.example.fednclient.grpc.ReassignRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.sender_ = senderBuilder_ == null
            ? sender_
            : senderBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.receiver_ = receiverBuilder_ == null
            ? receiver_
            : receiverBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.server_ = server_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.port_ = port_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.fednclient.grpc.ReassignRequest) {
        return mergeFrom((com.example.fednclient.grpc.ReassignRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.fednclient.grpc.ReassignRequest other) {
      if (other == com.example.fednclient.grpc.ReassignRequest.getDefaultInstance()) return this;
      if (other.hasSender()) {
        mergeSender(other.getSender());
      }
      if (other.hasReceiver()) {
        mergeReceiver(other.getReceiver());
      }
      if (!other.getServer().isEmpty()) {
        server_ = other.server_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (other.getPort() != 0) {
        setPort(other.getPort());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getSenderFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getReceiverFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              server_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              port_ = input.readUInt32();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.example.fednclient.grpc.Client sender_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.fednclient.grpc.Client, com.example.fednclient.grpc.Client.Builder, com.example.fednclient.grpc.ClientOrBuilder> senderBuilder_;
    /**
     * <code>.grpc.Client sender = 1;</code>
     * @return Whether the sender field is set.
     */
    public boolean hasSender() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     * @return The sender.
     */
    public com.example.fednclient.grpc.Client getSender() {
      if (senderBuilder_ == null) {
        return sender_ == null ? com.example.fednclient.grpc.Client.getDefaultInstance() : sender_;
      } else {
        return senderBuilder_.getMessage();
      }
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     */
    public Builder setSender(com.example.fednclient.grpc.Client value) {
      if (senderBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        sender_ = value;
      } else {
        senderBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     */
    public Builder setSender(
        com.example.fednclient.grpc.Client.Builder builderForValue) {
      if (senderBuilder_ == null) {
        sender_ = builderForValue.build();
      } else {
        senderBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     */
    public Builder mergeSender(com.example.fednclient.grpc.Client value) {
      if (senderBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          sender_ != null &&
          sender_ != com.example.fednclient.grpc.Client.getDefaultInstance()) {
          getSenderBuilder().mergeFrom(value);
        } else {
          sender_ = value;
        }
      } else {
        senderBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     */
    public Builder clearSender() {
      bitField0_ = (bitField0_ & ~0x00000001);
      sender_ = null;
      if (senderBuilder_ != null) {
        senderBuilder_.dispose();
        senderBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     */
    public com.example.fednclient.grpc.Client.Builder getSenderBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getSenderFieldBuilder().getBuilder();
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     */
    public com.example.fednclient.grpc.ClientOrBuilder getSenderOrBuilder() {
      if (senderBuilder_ != null) {
        return senderBuilder_.getMessageOrBuilder();
      } else {
        return sender_ == null ?
            com.example.fednclient.grpc.Client.getDefaultInstance() : sender_;
      }
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.fednclient.grpc.Client, com.example.fednclient.grpc.Client.Builder, com.example.fednclient.grpc.ClientOrBuilder> 
        getSenderFieldBuilder() {
      if (senderBuilder_ == null) {
        senderBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.example.fednclient.grpc.Client, com.example.fednclient.grpc.Client.Builder, com.example.fednclient.grpc.ClientOrBuilder>(
                getSender(),
                getParentForChildren(),
                isClean());
        sender_ = null;
      }
      return senderBuilder_;
    }

    private com.example.fednclient.grpc.Client receiver_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.fednclient.grpc.Client, com.example.fednclient.grpc.Client.Builder, com.example.fednclient.grpc.ClientOrBuilder> receiverBuilder_;
    /**
     * <code>.grpc.Client receiver = 2;</code>
     * @return Whether the receiver field is set.
     */
    public boolean hasReceiver() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     * @return The receiver.
     */
    public com.example.fednclient.grpc.Client getReceiver() {
      if (receiverBuilder_ == null) {
        return receiver_ == null ? com.example.fednclient.grpc.Client.getDefaultInstance() : receiver_;
      } else {
        return receiverBuilder_.getMessage();
      }
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     */
    public Builder setReceiver(com.example.fednclient.grpc.Client value) {
      if (receiverBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        receiver_ = value;
      } else {
        receiverBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     */
    public Builder setReceiver(
        com.example.fednclient.grpc.Client.Builder builderForValue) {
      if (receiverBuilder_ == null) {
        receiver_ = builderForValue.build();
      } else {
        receiverBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     */
    public Builder mergeReceiver(com.example.fednclient.grpc.Client value) {
      if (receiverBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          receiver_ != null &&
          receiver_ != com.example.fednclient.grpc.Client.getDefaultInstance()) {
          getReceiverBuilder().mergeFrom(value);
        } else {
          receiver_ = value;
        }
      } else {
        receiverBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     */
    public Builder clearReceiver() {
      bitField0_ = (bitField0_ & ~0x00000002);
      receiver_ = null;
      if (receiverBuilder_ != null) {
        receiverBuilder_.dispose();
        receiverBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     */
    public com.example.fednclient.grpc.Client.Builder getReceiverBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getReceiverFieldBuilder().getBuilder();
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     */
    public com.example.fednclient.grpc.ClientOrBuilder getReceiverOrBuilder() {
      if (receiverBuilder_ != null) {
        return receiverBuilder_.getMessageOrBuilder();
      } else {
        return receiver_ == null ?
            com.example.fednclient.grpc.Client.getDefaultInstance() : receiver_;
      }
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.fednclient.grpc.Client, com.example.fednclient.grpc.Client.Builder, com.example.fednclient.grpc.ClientOrBuilder> 
        getReceiverFieldBuilder() {
      if (receiverBuilder_ == null) {
        receiverBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.example.fednclient.grpc.Client, com.example.fednclient.grpc.Client.Builder, com.example.fednclient.grpc.ClientOrBuilder>(
                getReceiver(),
                getParentForChildren(),
                isClean());
        receiver_ = null;
      }
      return receiverBuilder_;
    }

    private java.lang.Object server_ = "";
    /**
     * <code>string server = 3;</code>
     * @return The server.
     */
    public java.lang.String getServer() {
      java.lang.Object ref = server_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        server_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string server = 3;</code>
     * @return The bytes for server.
     */
    public com.google.protobuf.ByteString
        getServerBytes() {
      java.lang.Object ref = server_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        server_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string server = 3;</code>
     * @param value The server to set.
     * @return This builder for chaining.
     */
    public Builder setServer(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      server_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string server = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearServer() {
      server_ = getDefaultInstance().getServer();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string server = 3;</code>
     * @param value The bytes for server to set.
     * @return This builder for chaining.
     */
    public Builder setServerBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      server_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private int port_ ;
    /**
     * <code>uint32 port = 4;</code>
     * @return The port.
     */
    @java.lang.Override
    public int getPort() {
      return port_;
    }
    /**
     * <code>uint32 port = 4;</code>
     * @param value The port to set.
     * @return This builder for chaining.
     */
    public Builder setPort(int value) {

      port_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 port = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPort() {
      bitField0_ = (bitField0_ & ~0x00000008);
      port_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpc.ReassignRequest)
  }

  // @@protoc_insertion_point(class_scope:grpc.ReassignRequest)
  private static final com.example.fednclient.grpc.ReassignRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.fednclient.grpc.ReassignRequest();
  }

  public static com.example.fednclient.grpc.ReassignRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ReassignRequest>
      PARSER = new com.google.protobuf.AbstractParser<ReassignRequest>() {
    @java.lang.Override
    public ReassignRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ReassignRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ReassignRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.fednclient.grpc.ReassignRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
