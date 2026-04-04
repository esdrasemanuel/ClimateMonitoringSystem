package com.esdras.alert;

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
    comments = "Source: DisasterAlertProto.proto")
public final class DisasterAlertServiceGrpc {

  private DisasterAlertServiceGrpc() {}

  public static final String SERVICE_NAME = "alert.DisasterAlertService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.esdras.alert.AlertRequest,
      com.esdras.alert.AlertResponse> getGenerateStormAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generateStormAlert",
      requestType = com.esdras.alert.AlertRequest.class,
      responseType = com.esdras.alert.AlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.esdras.alert.AlertRequest,
      com.esdras.alert.AlertResponse> getGenerateStormAlertMethod() {
    io.grpc.MethodDescriptor<com.esdras.alert.AlertRequest, com.esdras.alert.AlertResponse> getGenerateStormAlertMethod;
    if ((getGenerateStormAlertMethod = DisasterAlertServiceGrpc.getGenerateStormAlertMethod) == null) {
      synchronized (DisasterAlertServiceGrpc.class) {
        if ((getGenerateStormAlertMethod = DisasterAlertServiceGrpc.getGenerateStormAlertMethod) == null) {
          DisasterAlertServiceGrpc.getGenerateStormAlertMethod = getGenerateStormAlertMethod = 
              io.grpc.MethodDescriptor.<com.esdras.alert.AlertRequest, com.esdras.alert.AlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "alert.DisasterAlertService", "generateStormAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.alert.AlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.alert.AlertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DisasterAlertServiceMethodDescriptorSupplier("generateStormAlert"))
                  .build();
          }
        }
     }
     return getGenerateStormAlertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.esdras.alert.LiveAlertRequest,
      com.esdras.alert.AlertResponse> getStreamLiveAlertsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamLiveAlerts",
      requestType = com.esdras.alert.LiveAlertRequest.class,
      responseType = com.esdras.alert.AlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.esdras.alert.LiveAlertRequest,
      com.esdras.alert.AlertResponse> getStreamLiveAlertsMethod() {
    io.grpc.MethodDescriptor<com.esdras.alert.LiveAlertRequest, com.esdras.alert.AlertResponse> getStreamLiveAlertsMethod;
    if ((getStreamLiveAlertsMethod = DisasterAlertServiceGrpc.getStreamLiveAlertsMethod) == null) {
      synchronized (DisasterAlertServiceGrpc.class) {
        if ((getStreamLiveAlertsMethod = DisasterAlertServiceGrpc.getStreamLiveAlertsMethod) == null) {
          DisasterAlertServiceGrpc.getStreamLiveAlertsMethod = getStreamLiveAlertsMethod = 
              io.grpc.MethodDescriptor.<com.esdras.alert.LiveAlertRequest, com.esdras.alert.AlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "alert.DisasterAlertService", "streamLiveAlerts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.alert.LiveAlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.alert.AlertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DisasterAlertServiceMethodDescriptorSupplier("streamLiveAlerts"))
                  .build();
          }
        }
     }
     return getStreamLiveAlertsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DisasterAlertServiceStub newStub(io.grpc.Channel channel) {
    return new DisasterAlertServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DisasterAlertServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DisasterAlertServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DisasterAlertServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DisasterAlertServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DisasterAlertServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 1. Simple RPC
     * </pre>
     */
    public void generateStormAlert(com.esdras.alert.AlertRequest request,
        io.grpc.stub.StreamObserver<com.esdras.alert.AlertResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateStormAlertMethod(), responseObserver);
    }

    /**
     * <pre>
     * 2. Bidirectional Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.esdras.alert.LiveAlertRequest> streamLiveAlerts(
        io.grpc.stub.StreamObserver<com.esdras.alert.AlertResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamLiveAlertsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateStormAlertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.esdras.alert.AlertRequest,
                com.esdras.alert.AlertResponse>(
                  this, METHODID_GENERATE_STORM_ALERT)))
          .addMethod(
            getStreamLiveAlertsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.esdras.alert.LiveAlertRequest,
                com.esdras.alert.AlertResponse>(
                  this, METHODID_STREAM_LIVE_ALERTS)))
          .build();
    }
  }

  /**
   */
  public static final class DisasterAlertServiceStub extends io.grpc.stub.AbstractStub<DisasterAlertServiceStub> {
    private DisasterAlertServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DisasterAlertServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DisasterAlertServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DisasterAlertServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Simple RPC
     * </pre>
     */
    public void generateStormAlert(com.esdras.alert.AlertRequest request,
        io.grpc.stub.StreamObserver<com.esdras.alert.AlertResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGenerateStormAlertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 2. Bidirectional Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.esdras.alert.LiveAlertRequest> streamLiveAlerts(
        io.grpc.stub.StreamObserver<com.esdras.alert.AlertResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamLiveAlertsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class DisasterAlertServiceBlockingStub extends io.grpc.stub.AbstractStub<DisasterAlertServiceBlockingStub> {
    private DisasterAlertServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DisasterAlertServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DisasterAlertServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DisasterAlertServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Simple RPC
     * </pre>
     */
    public com.esdras.alert.AlertResponse generateStormAlert(com.esdras.alert.AlertRequest request) {
      return blockingUnaryCall(
          getChannel(), getGenerateStormAlertMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DisasterAlertServiceFutureStub extends io.grpc.stub.AbstractStub<DisasterAlertServiceFutureStub> {
    private DisasterAlertServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DisasterAlertServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DisasterAlertServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DisasterAlertServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Simple RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.esdras.alert.AlertResponse> generateStormAlert(
        com.esdras.alert.AlertRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGenerateStormAlertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_STORM_ALERT = 0;
  private static final int METHODID_STREAM_LIVE_ALERTS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DisasterAlertServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DisasterAlertServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_STORM_ALERT:
          serviceImpl.generateStormAlert((com.esdras.alert.AlertRequest) request,
              (io.grpc.stub.StreamObserver<com.esdras.alert.AlertResponse>) responseObserver);
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
        case METHODID_STREAM_LIVE_ALERTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamLiveAlerts(
              (io.grpc.stub.StreamObserver<com.esdras.alert.AlertResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DisasterAlertServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DisasterAlertServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.esdras.alert.DisasterAlertProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DisasterAlertService");
    }
  }

  private static final class DisasterAlertServiceFileDescriptorSupplier
      extends DisasterAlertServiceBaseDescriptorSupplier {
    DisasterAlertServiceFileDescriptorSupplier() {}
  }

  private static final class DisasterAlertServiceMethodDescriptorSupplier
      extends DisasterAlertServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DisasterAlertServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DisasterAlertServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DisasterAlertServiceFileDescriptorSupplier())
              .addMethod(getGenerateStormAlertMethod())
              .addMethod(getStreamLiveAlertsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
