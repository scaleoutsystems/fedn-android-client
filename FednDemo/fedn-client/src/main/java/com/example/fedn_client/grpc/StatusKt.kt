// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: fedn.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package com.example.fedn_client.grpc;

@kotlin.jvm.JvmName("-initializestatus")
public inline fun status(block: com.example.fedn_client.grpc.StatusKt.Dsl.() -> kotlin.Unit): com.example.fedn_client.grpc.Status =
  com.example.fedn_client.grpc.StatusKt.Dsl._create(com.example.fedn_client.grpc.Status.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `grpc.Status`
 */
public object StatusKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.example.fedn_client.grpc.Status.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.example.fedn_client.grpc.Status.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.example.fedn_client.grpc.Status = _builder.build()

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
     * ```
     *string client = 1;
     * ```
     *
     * `string status = 2;`
     */
    public var status: kotlin.String
      @JvmName("getStatus")
      get() = _builder.getStatus()
      @JvmName("setStatus")
      set(value) {
        _builder.setStatus(value)
      }
    /**
     * ```
     *string client = 1;
     * ```
     *
     * `string status = 2;`
     */
    public fun clearStatus() {
      _builder.clearStatus()
    }

    /**
     * `.grpc.Status.LogLevel log_level = 3;`
     */
    public var logLevel: com.example.fedn_client.grpc.Status.LogLevel
      @JvmName("getLogLevel")
      get() = _builder.getLogLevel()
      @JvmName("setLogLevel")
      set(value) {
        _builder.setLogLevel(value)
      }
    public var logLevelValue: kotlin.Int
      @JvmName("getLogLevelValue")
      get() = _builder.getLogLevelValue()
      @JvmName("setLogLevelValue")
      set(value) {
        _builder.setLogLevelValue(value)
      }
    /**
     * `.grpc.Status.LogLevel log_level = 3;`
     */
    public fun clearLogLevel() {
      _builder.clearLogLevel()
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
     * `.grpc.StatusType type = 7;`
     */
    public var type: com.example.fedn_client.grpc.StatusType
      @JvmName("getType")
      get() = _builder.getType()
      @JvmName("setType")
      set(value) {
        _builder.setType(value)
      }
    public var typeValue: kotlin.Int
      @JvmName("getTypeValue")
      get() = _builder.getTypeValue()
      @JvmName("setTypeValue")
      set(value) {
        _builder.setTypeValue(value)
      }
    /**
     * `.grpc.StatusType type = 7;`
     */
    public fun clearType() {
      _builder.clearType()
    }

    /**
     * `string extra = 8;`
     */
    public var extra: kotlin.String
      @JvmName("getExtra")
      get() = _builder.getExtra()
      @JvmName("setExtra")
      set(value) {
        _builder.setExtra(value)
      }
    /**
     * `string extra = 8;`
     */
    public fun clearExtra() {
      _builder.clearExtra()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.example.fedn_client.grpc.Status.copy(block: com.example.fedn_client.grpc.StatusKt.Dsl.() -> kotlin.Unit): com.example.fedn_client.grpc.Status =
  com.example.fedn_client.grpc.StatusKt.Dsl._create(this.toBuilder()).apply { block() }._build()

public val com.example.fedn_client.grpc.StatusOrBuilder.senderOrNull: com.example.fedn_client.grpc.Client?
  get() = if (hasSender()) getSender() else null

