// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fedn.proto

package com.example.fednclient.grpc;

public interface ResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.Response)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.grpc.Client sender = 1;</code>
   * @return Whether the sender field is set.
   */
  boolean hasSender();
  /**
   * <code>.grpc.Client sender = 1;</code>
   * @return The sender.
   */
  com.example.fednclient.grpc.Client getSender();
  /**
   * <code>.grpc.Client sender = 1;</code>
   */
  com.example.fednclient.grpc.ClientOrBuilder getSenderOrBuilder();

  /**
   * <pre>
   *string client = 1;
   * </pre>
   *
   * <code>string response = 2;</code>
   * @return The response.
   */
  java.lang.String getResponse();
  /**
   * <pre>
   *string client = 1;
   * </pre>
   *
   * <code>string response = 2;</code>
   * @return The bytes for response.
   */
  com.google.protobuf.ByteString
      getResponseBytes();
}
