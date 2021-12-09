package grpc.Boiler;

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
    comments = "Source: boiler.proto")
public final class BoilerServiceGrpc {

  private BoilerServiceGrpc() {}

  public static final String SERVICE_NAME = "BoilerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Boiler.BoilerRequest,
      grpc.Boiler.BoilerResponse> getSendBoilerRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendBoilerRequest",
      requestType = grpc.Boiler.BoilerRequest.class,
      responseType = grpc.Boiler.BoilerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Boiler.BoilerRequest,
      grpc.Boiler.BoilerResponse> getSendBoilerRequestMethod() {
    io.grpc.MethodDescriptor<grpc.Boiler.BoilerRequest, grpc.Boiler.BoilerResponse> getSendBoilerRequestMethod;
    if ((getSendBoilerRequestMethod = BoilerServiceGrpc.getSendBoilerRequestMethod) == null) {
      synchronized (BoilerServiceGrpc.class) {
        if ((getSendBoilerRequestMethod = BoilerServiceGrpc.getSendBoilerRequestMethod) == null) {
          BoilerServiceGrpc.getSendBoilerRequestMethod = getSendBoilerRequestMethod = 
              io.grpc.MethodDescriptor.<grpc.Boiler.BoilerRequest, grpc.Boiler.BoilerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "BoilerService", "sendBoilerRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Boiler.BoilerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Boiler.BoilerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BoilerServiceMethodDescriptorSupplier("sendBoilerRequest"))
                  .build();
          }
        }
     }
     return getSendBoilerRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BoilerServiceStub newStub(io.grpc.Channel channel) {
    return new BoilerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BoilerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BoilerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BoilerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BoilerServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BoilerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.Boiler.BoilerRequest> sendBoilerRequest(
        io.grpc.stub.StreamObserver<grpc.Boiler.BoilerResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendBoilerRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendBoilerRequestMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.Boiler.BoilerRequest,
                grpc.Boiler.BoilerResponse>(
                  this, METHODID_SEND_BOILER_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class BoilerServiceStub extends io.grpc.stub.AbstractStub<BoilerServiceStub> {
    private BoilerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BoilerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BoilerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BoilerServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.Boiler.BoilerRequest> sendBoilerRequest(
        io.grpc.stub.StreamObserver<grpc.Boiler.BoilerResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSendBoilerRequestMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class BoilerServiceBlockingStub extends io.grpc.stub.AbstractStub<BoilerServiceBlockingStub> {
    private BoilerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BoilerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BoilerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BoilerServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class BoilerServiceFutureStub extends io.grpc.stub.AbstractStub<BoilerServiceFutureStub> {
    private BoilerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BoilerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BoilerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BoilerServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_BOILER_REQUEST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BoilerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BoilerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_BOILER_REQUEST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendBoilerRequest(
              (io.grpc.stub.StreamObserver<grpc.Boiler.BoilerResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BoilerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BoilerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Boiler.BoilerImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BoilerService");
    }
  }

  private static final class BoilerServiceFileDescriptorSupplier
      extends BoilerServiceBaseDescriptorSupplier {
    BoilerServiceFileDescriptorSupplier() {}
  }

  private static final class BoilerServiceMethodDescriptorSupplier
      extends BoilerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BoilerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BoilerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BoilerServiceFileDescriptorSupplier())
              .addMethod(getSendBoilerRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
