// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: fedn.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package com.example.fedn_client.grpc;

@kotlin.jvm.JvmName("-initializemodelUpdate")
public inline fun modelUpdate(block: com.example.fedn_client.grpc.ModelUpdateKt.Dsl.() -> kotlin.Unit): com.example.fedn_client.grpc.ModelUpdate =
  com.example.fedn_client.grpc.ModelUpdateKt.Dsl._create(com.example.fedn_client.grpc.ModelUpdate.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `grpc.ModelUpdate`
 */
public object ModelUpdateKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.example.fedn_client.grpc.ModelUpdate.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.example.fedn_client.grpc.ModelUpdate.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.example.fedn_client.grpc.ModelUpdate = _builder.build()

    /**
     * `.grpc.Client sender = 1;`
     */
    public var sender: com.example.fedn_client.grpc.Client
      @JvmName("getSender")
      get() = _builder.getSender()
      @JvmName("setSender")
      set(value) {
        _builder.setSender(value)
      }
    /**
     * `.grpc.Client sender = 1;`
     */
    public fun clearSender() {
      _builder.clearSender()
    }
    /**
     * `.grpc.Client sender = 1;`
     * @return Whether the sender field is set.
     */
    public fun hasSender(): kotlin.Boolean {
      return _builder.hasSender()
    }

    /**
     * `.grpc.Client receiver = 2;`
     */
    public var receiver: com.example.fedn_client.grpc.Client
      @JvmName("getReceiver")
      get() = _builder.getReceiver()
      @JvmName("setReceiver")
      set(value) {
        _builder.setReceiver(value)
      }
    /**
     * `.grpc.Client receiver = 2;`
     */
    public fun clearReceiver() {
      _builder.clearReceiver()
    }
    /**
     * `.grpc.Client receiver = 2;`
     * @return Whether the receiver field is set.
     */
    public fun hasReceiver(): kotlin.Boolean {
      return _builder.hasReceiver()
    }

    /**
     * `string model_id = 3;`
     */
    public var modelId: kotlin.String
      @JvmName("getModelId")
      get() = _builder.getModelId()
      @JvmName("setModelId")
      set(value) {
        _builder.setModelId(value)
      }
    /**
     * `string model_id = 3;`
     */
    public fun clearModelId() {
      _builder.clearModelId()
    }

    /**
     * `string model_update_id = 4;`
     */
    public var modelUpdateId: kotlin.String
      @JvmName("getModelUpdateId")
      get() = _builder.getModelUpdateId()
      @JvmName("setModelUpdateId")
      set(value) {
        _builder.setModelUpdateId(value)
      }
    /**
     * `string model_update_id = 4;`
     */
    public fun clearModelUpdateId() {
      _builder.clearModelUpdateId()
    }

    /**
     * `string correlation_id = 5;`
     */
    public var correlationId: kotlin.String
      @JvmName("getCorrelationId")
      get() = _builder.getCorrelationId()
      @JvmName("setCorrelationId")
      set(value) {
        _builder.setCorrelationId(value)
      }
    /**
     * `string correlation_id = 5;`
     */
    public fun clearCorrelationId() {
      _builder.clearCorrelationId()
    }

    /**
     * `string timestamp = 6;`
     */
    public var timestamp: kotlin.String
      @JvmName("getTimestamp")
      get() = _builder.getTimestamp()
      @JvmName("setTimestamp")
      set(value) {
        _builder.setTimestamp(value)
      }
    /**
     * `string timestamp = 6;`
     */
    public fun clearTimestamp() {
      _builder.clearTimestamp()
    }

    /**
     * `string meta = 7;`
     */
    public var meta: kotlin.String
      @JvmName("getMeta")
      get() = _builder.getMeta()
      @JvmName("setMeta")
      set(value) {
        _builder.setMeta(value)
      }
    /**
     * `string meta = 7;`
     */
    public fun clearMeta() {
      _builder.clearMeta()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.example.fedn_client.grpc.ModelUpdate.copy(block: com.example.fedn_client.grpc.ModelUpdateKt.Dsl.() -> kotlin.Unit): com.example.fedn_client.grpc.ModelUpdate =
  com.example.fedn_client.grpc.ModelUpdateKt.Dsl._create(this.toBuilder()).apply { block() }._build()

public val com.example.fedn_client.grpc.ModelUpdateOrBuilder.senderOrNull: com.example.fedn_client.grpc.Client?
  get() = if (hasSender()) getSender() else null

public val com.example.fedn_client.grpc.ModelUpdateOrBuilder.receiverOrNull: com.example.fedn_client.grpc.Client?
  get() = if (hasReceiver()) getReceiver() else null

