// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fedn.proto

package com.example.fedn_client.grpc;

public interface ReportResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.ReportResponse)
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
  com.example.fedn_client.grpc.Client getSender();
  /**
   * <code>.grpc.Client sender = 1;</code>
   */
  com.example.fedn_client.grpc.ClientOrBuilder getSenderOrBuilder();

  /**
   * <code>repeated .grpc.Parameter parameter = 2;</code>
   */
  java.util.List<com.example.fedn_client.grpc.Parameter> 
      getParameterList();
  /**
   * <code>repeated .grpc.Parameter parameter = 2;</code>
   */
  com.example.fedn_client.grpc.Parameter getParameter(int index);
  /**
   * <code>repeated .grpc.Parameter parameter = 2;</code>
   */
  int getParameterCount();
  /**
   * <code>repeated .grpc.Parameter parameter = 2;</code>
   */
  java.util.List<? extends com.example.fedn_client.grpc.ParameterOrBuilder> 
      getParameterOrBuilderList();
  /**
   * <code>repeated .grpc.Parameter parameter = 2;</code>
   */
  com.example.fedn_client.grpc.ParameterOrBuilder getParameterOrBuilder(
      int index);
}