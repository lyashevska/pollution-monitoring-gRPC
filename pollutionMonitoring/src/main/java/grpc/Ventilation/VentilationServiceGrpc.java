package grpc.Ventilation;

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
    comments = "Source: ventilation.proto")
public final class VentilationServiceGrpc {

  private VentilationServiceGrpc() {}

  public static final String SERVICE_NAME = "VentilationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Ventilation.VentilationRequest,
      grpc.Ventilation.VentilationResponse> getSendVentilationRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendVentilationRequest",
      requestType = grpc.Ventilation.VentilationRequest.class,
      responseType = grpc.Ventilation.VentilationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Ventilation.VentilationRequest,
      grpc.Ventilation.VentilationResponse> getSendVentilationRequestMethod() {
    io.grpc.MethodDescriptor<grpc.Ventilation.VentilationRequest, grpc.Ventilation.VentilationResponse> getSendVentilationRequestMethod;
    if ((getSendVentilationRequestMethod = VentilationServiceGrpc.getSendVentilationRequestMethod) == null) {
      synchronized (VentilationServiceGrpc.class) {
        if ((getSendVentilationRequestMethod = VentilationServiceGrpc.getSendVentilationRequestMethod) == null) {
          VentilationServiceGrpc.getSendVentilationRequestMethod = getSendVentilationRequestMethod = 
              io.grpc.MethodDescriptor.<grpc.Ventilation.VentilationRequest, grpc.Ventilation.VentilationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "VentilationService", "sendVentilationRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Ventilation.VentilationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Ventilation.VentilationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new VentilationServiceMethodDescriptorSupplier("sendVentilationRequest"))
                  .build();
          }
        }
     }
     return getSendVentilationRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VentilationServiceStub newStub(io.grpc.Channel channel) {
    return new VentilationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VentilationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VentilationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VentilationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VentilationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class VentilationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendVentilationRequest(grpc.Ventilation.VentilationRequest request,
        io.grpc.stub.StreamObserver<grpc.Ventilation.VentilationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendVentilationRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendVentilationRequestMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.Ventilation.VentilationRequest,
                grpc.Ventilation.VentilationResponse>(
                  this, METHODID_SEND_VENTILATION_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class VentilationServiceStub extends io.grpc.stub.AbstractStub<VentilationServiceStub> {
    private VentilationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VentilationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VentilationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VentilationServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendVentilationRequest(grpc.Ventilation.VentilationRequest request,
        io.grpc.stub.StreamObserver<grpc.Ventilation.VentilationResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSendVentilationRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VentilationServiceBlockingStub extends io.grpc.stub.AbstractStub<VentilationServiceBlockingStub> {
    private VentilationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VentilationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VentilationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VentilationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<grpc.Ventilation.VentilationResponse> sendVentilationRequest(
        grpc.Ventilation.VentilationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSendVentilationRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VentilationServiceFutureStub extends io.grpc.stub.AbstractStub<VentilationServiceFutureStub> {
    private VentilationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VentilationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VentilationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VentilationServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_VENTILATION_REQUEST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VentilationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VentilationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_VENTILATION_REQUEST:
          serviceImpl.sendVentilationRequest((grpc.Ventilation.VentilationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Ventilation.VentilationResponse>) responseObserver);
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

  private static abstract class VentilationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VentilationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Ventilation.VentilationImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VentilationService");
    }
  }

  private static final class VentilationServiceFileDescriptorSupplier
      extends VentilationServiceBaseDescriptorSupplier {
    VentilationServiceFileDescriptorSupplier() {}
  }

  private static final class VentilationServiceMethodDescriptorSupplier
      extends VentilationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VentilationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VentilationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VentilationServiceFileDescriptorSupplier())
              .addMethod(getSendVentilationRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
