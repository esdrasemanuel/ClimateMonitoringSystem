package com.esdras.climate;

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
    comments = "Source: ClimateSensorProto.proto")
public final class ClimateSensorServiceGrpc {

  private ClimateSensorServiceGrpc() {}

  public static final String SERVICE_NAME = "climate.ClimateSensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.esdras.climate.ClimateRequest,
      com.esdras.climate.ClimateResponse> getGetCurrentClimateDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentClimateData",
      requestType = com.esdras.climate.ClimateRequest.class,
      responseType = com.esdras.climate.ClimateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.esdras.climate.ClimateRequest,
      com.esdras.climate.ClimateResponse> getGetCurrentClimateDataMethod() {
    io.grpc.MethodDescriptor<com.esdras.climate.ClimateRequest, com.esdras.climate.ClimateResponse> getGetCurrentClimateDataMethod;
    if ((getGetCurrentClimateDataMethod = ClimateSensorServiceGrpc.getGetCurrentClimateDataMethod) == null) {
      synchronized (ClimateSensorServiceGrpc.class) {
        if ((getGetCurrentClimateDataMethod = ClimateSensorServiceGrpc.getGetCurrentClimateDataMethod) == null) {
          ClimateSensorServiceGrpc.getGetCurrentClimateDataMethod = getGetCurrentClimateDataMethod = 
              io.grpc.MethodDescriptor.<com.esdras.climate.ClimateRequest, com.esdras.climate.ClimateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "climate.ClimateSensorService", "getCurrentClimateData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.climate.ClimateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.climate.ClimateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClimateSensorServiceMethodDescriptorSupplier("getCurrentClimateData"))
                  .build();
          }
        }
     }
     return getGetCurrentClimateDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.esdras.climate.ClimateRequest,
      com.esdras.climate.ClimateResponse> getStreamLiveClimateDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamLiveClimateData",
      requestType = com.esdras.climate.ClimateRequest.class,
      responseType = com.esdras.climate.ClimateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.esdras.climate.ClimateRequest,
      com.esdras.climate.ClimateResponse> getStreamLiveClimateDataMethod() {
    io.grpc.MethodDescriptor<com.esdras.climate.ClimateRequest, com.esdras.climate.ClimateResponse> getStreamLiveClimateDataMethod;
    if ((getStreamLiveClimateDataMethod = ClimateSensorServiceGrpc.getStreamLiveClimateDataMethod) == null) {
      synchronized (ClimateSensorServiceGrpc.class) {
        if ((getStreamLiveClimateDataMethod = ClimateSensorServiceGrpc.getStreamLiveClimateDataMethod) == null) {
          ClimateSensorServiceGrpc.getStreamLiveClimateDataMethod = getStreamLiveClimateDataMethod = 
              io.grpc.MethodDescriptor.<com.esdras.climate.ClimateRequest, com.esdras.climate.ClimateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "climate.ClimateSensorService", "streamLiveClimateData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.climate.ClimateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.esdras.climate.ClimateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClimateSensorServiceMethodDescriptorSupplier("streamLiveClimateData"))
                  .build();
          }
        }
     }
     return getStreamLiveClimateDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClimateSensorServiceStub newStub(io.grpc.Channel channel) {
    return new ClimateSensorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClimateSensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClimateSensorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClimateSensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClimateSensorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClimateSensorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCurrentClimateData(com.esdras.climate.ClimateRequest request,
        io.grpc.stub.StreamObserver<com.esdras.climate.ClimateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentClimateDataMethod(), responseObserver);
    }

    /**
     */
    public void streamLiveClimateData(com.esdras.climate.ClimateRequest request,
        io.grpc.stub.StreamObserver<com.esdras.climate.ClimateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamLiveClimateDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCurrentClimateDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.esdras.climate.ClimateRequest,
                com.esdras.climate.ClimateResponse>(
                  this, METHODID_GET_CURRENT_CLIMATE_DATA)))
          .addMethod(
            getStreamLiveClimateDataMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.esdras.climate.ClimateRequest,
                com.esdras.climate.ClimateResponse>(
                  this, METHODID_STREAM_LIVE_CLIMATE_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class ClimateSensorServiceStub extends io.grpc.stub.AbstractStub<ClimateSensorServiceStub> {
    private ClimateSensorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClimateSensorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClimateSensorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClimateSensorServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCurrentClimateData(com.esdras.climate.ClimateRequest request,
        io.grpc.stub.StreamObserver<com.esdras.climate.ClimateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentClimateDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamLiveClimateData(com.esdras.climate.ClimateRequest request,
        io.grpc.stub.StreamObserver<com.esdras.climate.ClimateResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamLiveClimateDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClimateSensorServiceBlockingStub extends io.grpc.stub.AbstractStub<ClimateSensorServiceBlockingStub> {
    private ClimateSensorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClimateSensorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClimateSensorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClimateSensorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.esdras.climate.ClimateResponse getCurrentClimateData(com.esdras.climate.ClimateRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentClimateDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.esdras.climate.ClimateResponse> streamLiveClimateData(
        com.esdras.climate.ClimateRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamLiveClimateDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClimateSensorServiceFutureStub extends io.grpc.stub.AbstractStub<ClimateSensorServiceFutureStub> {
    private ClimateSensorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClimateSensorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClimateSensorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClimateSensorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.esdras.climate.ClimateResponse> getCurrentClimateData(
        com.esdras.climate.ClimateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentClimateDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_CLIMATE_DATA = 0;
  private static final int METHODID_STREAM_LIVE_CLIMATE_DATA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClimateSensorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClimateSensorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT_CLIMATE_DATA:
          serviceImpl.getCurrentClimateData((com.esdras.climate.ClimateRequest) request,
              (io.grpc.stub.StreamObserver<com.esdras.climate.ClimateResponse>) responseObserver);
          break;
        case METHODID_STREAM_LIVE_CLIMATE_DATA:
          serviceImpl.streamLiveClimateData((com.esdras.climate.ClimateRequest) request,
              (io.grpc.stub.StreamObserver<com.esdras.climate.ClimateResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ClimateSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClimateSensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.esdras.climate.ClimateSensorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClimateSensorService");
    }
  }

  private static final class ClimateSensorServiceFileDescriptorSupplier
      extends ClimateSensorServiceBaseDescriptorSupplier {
    ClimateSensorServiceFileDescriptorSupplier() {}
  }

  private static final class ClimateSensorServiceMethodDescriptorSupplier
      extends ClimateSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClimateSensorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClimateSensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClimateSensorServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentClimateDataMethod())
              .addMethod(getStreamLiveClimateDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
