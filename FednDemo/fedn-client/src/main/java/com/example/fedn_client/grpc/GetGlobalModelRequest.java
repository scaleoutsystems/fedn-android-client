// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fedn.proto

package com.example.fedn_client.grpc;

/**
 * Protobuf type {@code grpc.GetGlobalModelRequest}
 */
public final class GetGlobalModelRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.GetGlobalModelRequest)
    GetGlobalModelRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetGlobalModelRequest.newBuilder() to construct.
  private GetGlobalModelRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetGlobalModelRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetGlobalModelRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.fedn_client.grpc.Fedn.internal_static_grpc_GetGlobalModelRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.fedn_client.grpc.Fedn.internal_static_grpc_GetGlobalModelRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.fedn_client.grpc.GetGlobalModelRequest.class, com.example.fedn_client.grpc.GetGlobalModelRequest.Builder.class);
  }

  public static final int SENDER_FIELD_NUMBER = 1;
  private com.example.fedn_client.grpc.Client sender_;
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
  public com.example.fedn_client.grpc.Client getSender() {
    return sender_ == null ? com.example.fedn_client.grpc.Client.getDefaultInstance() : sender_;
  }
  /**
   * <code>.grpc.Client sender = 1;</code>
   */
  @java.lang.Override
  public com.example.fedn_client.grpc.ClientOrBuilder getSenderOrBuilder() {
    return sender_ == null ? com.example.fedn_client.grpc.Client.getDefaultInstance() : sender_;
  }

  public static final int RECEIVER_FIELD_NUMBER = 2;
  private com.example.fedn_client.grpc.Client receiver_;
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
  public com.example.fedn_client.grpc.Client getReceiver() {
    return receiver_ == null ? com.example.fedn_client.grpc.Client.getDefaultInstance() : receiver_;
  }
  /**
   * <code>.grpc.Client receiver = 2;</code>
   */
  @java.lang.Override
  public com.example.fedn_client.grpc.ClientOrBuilder getReceiverOrBuilder() {
    return receiver_ == null ? com.example.fedn_client.grpc.Client.getDefaultInstance() : receiver_;
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
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.fedn_client.grpc.GetGlobalModelRequest)) {
      return super.equals(obj);
    }
    com.example.fedn_client.grpc.GetGlobalModelRequest other = (com.example.fedn_client.grpc.GetGlobalModelRequest) obj;

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
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.fedn_client.grpc.GetGlobalModelRequest parseFrom(
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
  public static Builder newBuilder(com.example.fedn_client.grpc.GetGlobalModelRequest prototype) {
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
   * Protobuf type {@code grpc.GetGlobalModelRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.GetGlobalModelRequest)
      com.example.fedn_client.grpc.GetGlobalModelRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.fedn_client.grpc.Fedn.internal_static_grpc_GetGlobalModelRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.fedn_client.grpc.Fedn.internal_static_grpc_GetGlobalModelRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.fedn_client.grpc.GetGlobalModelRequest.class, com.example.fedn_client.grpc.GetGlobalModelRequest.Builder.class);
    }

    // Construct using com.example.fedn_client.grpc.GetGlobalModelRequest.newBuilder()
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
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.fedn_client.grpc.Fedn.internal_static_grpc_GetGlobalModelRequest_descriptor;
    }

    @java.lang.Override
    public com.example.fedn_client.grpc.GetGlobalModelRequest getDefaultInstanceForType() {
      return com.example.fedn_client.grpc.GetGlobalModelRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.fedn_client.grpc.GetGlobalModelRequest build() {
      com.example.fedn_client.grpc.GetGlobalModelRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.fedn_client.grpc.GetGlobalModelRequest buildPartial() {
      com.example.fedn_client.grpc.GetGlobalModelRequest result = new com.example.fedn_client.grpc.GetGlobalModelRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.example.fedn_client.grpc.GetGlobalModelRequest result) {
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
      if (other instanceof com.example.fedn_client.grpc.GetGlobalModelRequest) {
        return mergeFrom((com.example.fedn_client.grpc.GetGlobalModelRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.fedn_client.grpc.GetGlobalModelRequest other) {
      if (other == com.example.fedn_client.grpc.GetGlobalModelRequest.getDefaultInstance()) return this;
      if (other.hasSender()) {
        mergeSender(other.getSender());
      }
      if (other.hasReceiver()) {
        mergeReceiver(other.getReceiver());
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

    private com.example.fedn_client.grpc.Client sender_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.fedn_client.grpc.Client, com.example.fedn_client.grpc.Client.Builder, com.example.fedn_client.grpc.ClientOrBuilder> senderBuilder_;
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
    public com.example.fedn_client.grpc.Client getSender() {
      if (senderBuilder_ == null) {
        return sender_ == null ? com.example.fedn_client.grpc.Client.getDefaultInstance() : sender_;
      } else {
        return senderBuilder_.getMessage();
      }
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     */
    public Builder setSender(com.example.fedn_client.grpc.Client value) {
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
        com.example.fedn_client.grpc.Client.Builder builderForValue) {
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
    public Builder mergeSender(com.example.fedn_client.grpc.Client value) {
      if (senderBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          sender_ != null &&
          sender_ != com.example.fedn_client.grpc.Client.getDefaultInstance()) {
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
    public com.example.fedn_client.grpc.Client.Builder getSenderBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getSenderFieldBuilder().getBuilder();
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     */
    public com.example.fedn_client.grpc.ClientOrBuilder getSenderOrBuilder() {
      if (senderBuilder_ != null) {
        return senderBuilder_.getMessageOrBuilder();
      } else {
        return sender_ == null ?
            com.example.fedn_client.grpc.Client.getDefaultInstance() : sender_;
      }
    }
    /**
     * <code>.grpc.Client sender = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.fedn_client.grpc.Client, com.example.fedn_client.grpc.Client.Builder, com.example.fedn_client.grpc.ClientOrBuilder> 
        getSenderFieldBuilder() {
      if (senderBuilder_ == null) {
        senderBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.example.fedn_client.grpc.Client, com.example.fedn_client.grpc.Client.Builder, com.example.fedn_client.grpc.ClientOrBuilder>(
                getSender(),
                getParentForChildren(),
                isClean());
        sender_ = null;
      }
      return senderBuilder_;
    }

    private com.example.fedn_client.grpc.Client receiver_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.fedn_client.grpc.Client, com.example.fedn_client.grpc.Client.Builder, com.example.fedn_client.grpc.ClientOrBuilder> receiverBuilder_;
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
    public com.example.fedn_client.grpc.Client getReceiver() {
      if (receiverBuilder_ == null) {
        return receiver_ == null ? com.example.fedn_client.grpc.Client.getDefaultInstance() : receiver_;
      } else {
        return receiverBuilder_.getMessage();
      }
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     */
    public Builder setReceiver(com.example.fedn_client.grpc.Client value) {
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
        com.example.fedn_client.grpc.Client.Builder builderForValue) {
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
    public Builder mergeReceiver(com.example.fedn_client.grpc.Client value) {
      if (receiverBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          receiver_ != null &&
          receiver_ != com.example.fedn_client.grpc.Client.getDefaultInstance()) {
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
    public com.example.fedn_client.grpc.Client.Builder getReceiverBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getReceiverFieldBuilder().getBuilder();
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     */
    public com.example.fedn_client.grpc.ClientOrBuilder getReceiverOrBuilder() {
      if (receiverBuilder_ != null) {
        return receiverBuilder_.getMessageOrBuilder();
      } else {
        return receiver_ == null ?
            com.example.fedn_client.grpc.Client.getDefaultInstance() : receiver_;
      }
    }
    /**
     * <code>.grpc.Client receiver = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.fedn_client.grpc.Client, com.example.fedn_client.grpc.Client.Builder, com.example.fedn_client.grpc.ClientOrBuilder> 
        getReceiverFieldBuilder() {
      if (receiverBuilder_ == null) {
        receiverBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.example.fedn_client.grpc.Client, com.example.fedn_client.grpc.Client.Builder, com.example.fedn_client.grpc.ClientOrBuilder>(
                getReceiver(),
                getParentForChildren(),
                isClean());
        receiver_ = null;
      }
      return receiverBuilder_;
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


    // @@protoc_insertion_point(builder_scope:grpc.GetGlobalModelRequest)
  }

  // @@protoc_insertion_point(class_scope:grpc.GetGlobalModelRequest)
  private static final com.example.fedn_client.grpc.GetGlobalModelRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.fedn_client.grpc.GetGlobalModelRequest();
  }

  public static com.example.fedn_client.grpc.GetGlobalModelRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetGlobalModelRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetGlobalModelRequest>() {
    @java.lang.Override
    public GetGlobalModelRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetGlobalModelRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetGlobalModelRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.fedn_client.grpc.GetGlobalModelRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
