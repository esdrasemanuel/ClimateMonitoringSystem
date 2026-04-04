package com.esdras.river;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: RiverLevelProto.proto")
public final class RiverLevelServiceGrpc {

  private RiverLevelServiceGrpc() {}

  public static final String SERVICE_NAME = "river.RiverLevelService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.esdras.river.RiverRequest,
      com.esdras.river.RiverResponse> getGetCurrentRiverLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentRiverLevel",
      requestType = com.esdras.river.RiverRequest.class,
      responseType = com.esdras.river.RiverResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.esdras.river.RiverRequest,
      com.esdras.river.RiverResponse> getGetCurrentRiverLevelMethod() {
    io.grpc.MethodDescriptor<com.esdras.river.RiverRequest, com.esdras.river.RiverResponse> getGetCurrentRiverLevelMethod;
    if ((getGetCurrentRiverLevelMethod = RiverLevelServiceGrpc.getGetCurrentRiverLevelMethod) == null) {
      synchronized (RiverLevelServiceGrpc.class) {
        if ((getGetCurrentRiverLevelMethod = RiverLevelServiceGrpc.getGetCurrentRiverLevelMethod) == null) {
          RiverLevelServiceGrpc.getGetCurrentRiverLevelMethod = getGetCurrentRiverLevelMethod = 
              io.grpc.MethodDescriptor.<com.esdras.river.RiverRequest, com.esdras.river.RiverResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "river.RiverLevelService", "getCurrentRiverLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.river.RiverRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.river.RiverResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RiverLevelServiceMethodDescriptorSupplier("getCurrentRiverLevel"))
                  .build();
          }
        }
     }
     return getGetCurrentRiverLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.esdras.river.RainfallData,
      com.esdras.river.RainfallAnalysis> getUploadRainfallDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "uploadRainfallData",
      requestType = com.esdras.river.RainfallData.class,
      responseType = com.esdras.river.RainfallAnalysis.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.esdras.river.RainfallData,
      com.esdras.river.RainfallAnalysis> getUploadRainfallDataMethod() {
    io.grpc.MethodDescriptor<com.esdras.river.RainfallData, com.esdras.river.RainfallAnalysis> getUploadRainfallDataMethod;
    if ((getUploadRainfallDataMethod = RiverLevelServiceGrpc.getUploadRainfallDataMethod) == null) {
      synchronized (RiverLevelServiceGrpc.class) {
        if ((getUploadRainfallDataMethod = RiverLevelServiceGrpc.getUploadRainfallDataMethod) == null) {
          RiverLevelServiceGrpc.getUploadRainfallDataMethod = getUploadRainfallDataMethod = 
              io.grpc.MethodDescriptor.<com.esdras.river.RainfallData, com.esdras.river.RainfallAnalysis>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "river.RiverLevelService", "uploadRainfallData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.river.RainfallData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.river.RainfallAnalysis.getDefaultInstance()))
                  .setSchemaDescriptor(new RiverLevelServiceMethodDescriptorSupplier("uploadRainfallData"))
                  .build();
          }
        }
     }
     return getUploadRainfallDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.esdras.river.RiverRequestBidi,
      com.esdras.river.RiverResponse> getMonitorRiverLevelLiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "monitorRiverLevelLive",
      requestType = com.esdras.river.RiverRequestBidi.class,
      responseType = com.esdras.river.RiverResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.esdras.river.RiverRequestBidi,
      com.esdras.river.RiverResponse> getMonitorRiverLevelLiveMethod() {
    io.grpc.MethodDescriptor<com.esdras.river.RiverRequestBidi, com.esdras.river.RiverResponse> getMonitorRiverLevelLiveMethod;
    if ((getMonitorRiverLevelLiveMethod = RiverLevelServiceGrpc.getMonitorRiverLevelLiveMethod) == null) {
      synchronized (RiverLevelServiceGrpc.class) {
        if ((getMonitorRiverLevelLiveMethod = RiverLevelServiceGrpc.getMonitorRiverLevelLiveMethod) == null) {
          RiverLevelServiceGrpc.getMonitorRiverLevelLiveMethod = getMonitorRiverLevelLiveMethod = 
              io.grpc.MethodDescriptor.<com.esdras.river.RiverRequestBidi, com.esdras.river.RiverResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "river.RiverLevelService", "monitorRiverLevelLive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.river.RiverRequestBidi.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.river.RiverResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RiverLevelServiceMethodDescriptorSupplier("monitorRiverLevelLive"))
                  .build();
          }
        }
     }
     return getMonitorRiverLevelLiveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RiverLevelServiceStub newStub(io.grpc.Channel channel) {
    return new RiverLevelServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RiverLevelServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RiverLevelServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RiverLevelServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RiverLevelServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RiverLevelServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 1. Simple RPC
     * </pre>
     */
    public void getCurrentRiverLevel(com.esdras.river.RiverRequest request,
        io.grpc.stub.StreamObserver<com.esdras.river.RiverResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentRiverLevelMethod(), responseObserver);
    }

    /**
     * <pre>
     * 2. Client Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.esdras.river.RainfallData> uploadRainfallData(
        io.grpc.stub.StreamObserver<com.esdras.river.RainfallAnalysis> responseObserver) {
      return asyncUnimplementedStreamingCall(getUploadRainfallDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * 3. Bidirectional Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.esdras.river.RiverRequestBidi> monitorRiverLevelLive(
        io.grpc.stub.StreamObserver<com.esdras.river.RiverResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getMonitorRiverLevelLiveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCurrentRiverLevelMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.esdras.river.RiverRequest,
                com.esdras.river.RiverResponse>(
                  this, METHODID_GET_CURRENT_RIVER_LEVEL)))
          .addMethod(
            getUploadRainfallDataMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.esdras.river.RainfallData,
                com.esdras.river.RainfallAnalysis>(
                  this, METHODID_UPLOAD_RAINFALL_DATA)))
          .addMethod(
            getMonitorRiverLevelLiveMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.esdras.river.RiverRequestBidi,
                com.esdras.river.RiverResponse>(
                  this, METHODID_MONITOR_RIVER_LEVEL_LIVE)))
          .build();
    }
  }

  /**
   */
  public static final class RiverLevelServiceStub extends io.grpc.stub.AbstractStub<RiverLevelServiceStub> {
    private RiverLevelServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RiverLevelServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RiverLevelServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RiverLevelServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Simple RPC
     * </pre>
     */
    public void getCurrentRiverLevel(com.esdras.river.RiverRequest request,
        io.grpc.stub.StreamObserver<com.esdras.river.RiverResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentRiverLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 2. Client Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.esdras.river.RainfallData> uploadRainfallData(
        io.grpc.stub.StreamObserver<com.esdras.river.RainfallAnalysis> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUploadRainfallDataMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 3. Bidirectional Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.esdras.river.RiverRequestBidi> monitorRiverLevelLive(
        io.grpc.stub.StreamObserver<com.esdras.river.RiverResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getMonitorRiverLevelLiveMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class RiverLevelServiceBlockingStub extends io.grpc.stub.AbstractStub<RiverLevelServiceBlockingStub> {
    private RiverLevelServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RiverLevelServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RiverLevelServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RiverLevelServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Simple RPC
     * </pre>
     */
    public com.esdras.river.RiverResponse getCurrentRiverLevel(com.esdras.river.RiverRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentRiverLevelMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RiverLevelServiceFutureStub extends io.grpc.stub.AbstractStub<RiverLevelServiceFutureStub> {
    private RiverLevelServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RiverLevelServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RiverLevelServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RiverLevelServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Simple RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.esdras.river.RiverResponse> getCurrentRiverLevel(
        com.esdras.river.RiverRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentRiverLevelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_RIVER_LEVEL = 0;
  private static final int METHODID_UPLOAD_RAINFALL_DATA = 1;
  private static final int METHODID_MONITOR_RIVER_LEVEL_LIVE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RiverLevelServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RiverLevelServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT_RIVER_LEVEL:
          serviceImpl.getCurrentRiverLevel((com.esdras.river.RiverRequest) request,
              (io.grpc.stub.StreamObserver<com.esdras.river.RiverResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD_RAINFALL_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadRainfallData(
              (io.grpc.stub.StreamObserver<com.esdras.river.RainfallAnalysis>) responseObserver);
        case METHODID_MONITOR_RIVER_LEVEL_LIVE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorRiverLevelLive(
              (io.grpc.stub.StreamObserver<com.esdras.river.RiverResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RiverLevelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RiverLevelServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.esdras.river.RiverLevelProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RiverLevelService");
    }
  }

  private static final class RiverLevelServiceFileDescriptorSupplier
      extends RiverLevelServiceBaseDescriptorSupplier {
    RiverLevelServiceFileDescriptorSupplier() {}
  }

  private static final class RiverLevelServiceMethodDescriptorSupplier
      extends RiverLevelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RiverLevelServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RiverLevelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RiverLevelServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentRiverLevelMethod())
              .addMethod(getUploadRainfallDataMethod())
              .addMethod(getMonitorRiverLevelLiveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
