// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fedn.proto

package com.example.fednclient.grpc;

/**
 * Protobuf enum {@code grpc.Channel}
 */
public enum Channel
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>DEFAULT = 0;</code>
   */
  DEFAULT(0),
  /**
   * <code>MODEL_UPDATE_REQUESTS = 1;</code>
   */
  MODEL_UPDATE_REQUESTS(1),
  /**
   * <code>MODEL_UPDATES = 2;</code>
   */
  MODEL_UPDATES(2),
  /**
   * <code>MODEL_VALIDATION_REQUESTS = 3;</code>
   */
  MODEL_VALIDATION_REQUESTS(3),
  /**
   * <code>MODEL_VALIDATIONS = 4;</code>
   */
  MODEL_VALIDATIONS(4),
  /**
   * <code>STATUS = 5;</code>
   */
  STATUS(5),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>DEFAULT = 0;</code>
   */
  public static final int DEFAULT_VALUE = 0;
  /**
   * <code>MODEL_UPDATE_REQUESTS = 1;</code>
   */
  public static final int MODEL_UPDATE_REQUESTS_VALUE = 1;
  /**
   * <code>MODEL_UPDATES = 2;</code>
   */
  public static final int MODEL_UPDATES_VALUE = 2;
  /**
   * <code>MODEL_VALIDATION_REQUESTS = 3;</code>
   */
  public static final int MODEL_VALIDATION_REQUESTS_VALUE = 3;
  /**
   * <code>MODEL_VALIDATIONS = 4;</code>
   */
  public static final int MODEL_VALIDATIONS_VALUE = 4;
  /**
   * <code>STATUS = 5;</code>
   */
  public static final int STATUS_VALUE = 5;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Channel valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Channel forNumber(int value) {
    switch (value) {
      case 0: return DEFAULT;
      case 1: return MODEL_UPDATE_REQUESTS;
      case 2: return MODEL_UPDATES;
      case 3: return MODEL_VALIDATION_REQUESTS;
      case 4: return MODEL_VALIDATIONS;
      case 5: return STATUS;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Channel>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Channel> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Channel>() {
          public Channel findValueByNumber(int number) {
            return Channel.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.example.fednclient.grpc.Fedn.getDescriptor().getEnumTypes().get(1);
  }

  private static final Channel[] VALUES = values();

  public static Channel valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Channel(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:grpc.Channel)
}

