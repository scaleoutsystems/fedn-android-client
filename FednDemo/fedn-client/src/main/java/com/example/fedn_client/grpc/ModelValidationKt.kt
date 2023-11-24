// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: fedn.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package com.example.fedn_client.grpc;

@kotlin.jvm.JvmName("-initializemodelValidation")
public inline fun modelValidation(block: com.example.fedn_client.grpc.ModelValidationKt.Dsl.() -> kotlin.Unit): com.example.fedn_client.grpc.ModelValidation =
  com.example.fedn_client.grpc.ModelValidationKt.Dsl._create(com.example.fedn_client.grpc.ModelValidation.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `grpc.ModelValidation`
 */
public object ModelValidationKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.example.fedn_client.grpc.ModelValidation.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.example.fedn_client.grpc.ModelValidation.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.example.fedn_client.grpc.ModelValidation = _builder.build()

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
     * `string data = 4;`
     */
    public var data: kotlin.String
      @JvmName("getData")
      get() = _builder.getData()
      @JvmName("setData")
      set(value) {
        _builder.setData(value)
      }
    /**
     * `string data = 4;`
     */
    public fun clearData() {
      _builder.clearData()
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
public inline fun com.example.fedn_client.grpc.ModelValidation.copy(block: com.example.fedn_client.grpc.ModelValidationKt.Dsl.() -> kotlin.Unit): com.example.fedn_client.grpc.ModelValidation =
  com.example.fedn_client.grpc.ModelValidationKt.Dsl._create(this.toBuilder()).apply { block() }._build()

public val com.example.fedn_client.grpc.ModelValidationOrBuilder.senderOrNull: com.example.fedn_client.grpc.Client?
  get() = if (hasSender()) getSender() else null

public val com.example.fedn_client.grpc.ModelValidationOrBuilder.receiverOrNull: com.example.fedn_client.grpc.Client?
  get() = if (hasReceiver()) getReceiver() else null

