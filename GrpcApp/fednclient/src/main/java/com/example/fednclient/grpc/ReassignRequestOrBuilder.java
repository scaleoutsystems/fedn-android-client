// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fedn.proto

package com.example.fednclient.grpc;

public interface ReassignRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.ReassignRequest)
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
   * <code>.grpc.Client receiver = 2;</code>
   * @return Whether the receiver field is set.
   */
  boolean hasReceiver();
  /**
   * <code>.grpc.Client receiver = 2;</code>
   * @return The receiver.
   */
  com.example.fednclient.grpc.Client getReceiver();
  /**
   * <code>.grpc.Client receiver = 2;</code>
   */
  com.example.fednclient.grpc.ClientOrBuilder getReceiverOrBuilder();

  /**
   * <code>string server = 3;</code>
   * @return The server.
   */
  java.lang.String getServer();
  /**
   * <code>string server = 3;</code>
   * @return The bytes for server.
   */
  com.google.protobuf.ByteString
      getServerBytes();

  /**
   * <code>uint32 port = 4;</code>
   * @return The port.
   */
  int getPort();
}
