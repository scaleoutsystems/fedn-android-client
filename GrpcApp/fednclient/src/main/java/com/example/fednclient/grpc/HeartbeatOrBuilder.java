// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fedn.proto

package com.example.fednclient.grpc;

public interface HeartbeatOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.Heartbeat)
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
}
