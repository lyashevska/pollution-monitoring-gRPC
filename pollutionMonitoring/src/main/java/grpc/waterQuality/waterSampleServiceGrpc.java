package grpc.waterQuality;

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
    comments = "Source: waterQuality.proto")
public final class waterSampleServiceGrpc {

  private waterSampleServiceGrpc() {}

  public static final String SERVICE_NAME = "waterSampleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.waterQuality.SampleRequest,
      grpc.waterQuality.SampleResponse> getCreateSampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSample",
      requestType = grpc.waterQuality.SampleRequest.class,
      responseType = grpc.waterQuality.SampleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.waterQuality.SampleRequest,
      grpc.waterQuality.SampleResponse> getCreateSampleMethod() {
    io.grpc.MethodDescriptor<grpc.waterQuality.SampleRequest, grpc.waterQuality.SampleResponse> getCreateSampleMethod;
    if ((getCreateSampleMethod = waterSampleServiceGrpc.getCreateSampleMethod) == null) {
      synchronized (waterSampleServiceGrpc.class) {
        if ((getCreateSampleMethod = waterSampleServiceGrpc.getCreateSampleMethod) == null) {
          waterSampleServiceGrpc.getCreateSampleMethod = getCreateSampleMethod = 
              io.grpc.MethodDescriptor.<grpc.waterQuality.SampleRequest, grpc.waterQuality.SampleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "waterSampleService", "CreateSample"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.waterQuality.SampleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.waterQuality.SampleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new waterSampleServiceMethodDescriptorSupplier("CreateSample"))
                  .build();
          }
        }
     }
     return getCreateSampleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static waterSampleServiceStub newStub(io.grpc.Channel channel) {
    return new waterSampleServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static waterSampleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new waterSampleServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static waterSampleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new waterSampleServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class waterSampleServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * bidirectional
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.waterQuality.SampleRequest> createSample(
        io.grpc.stub.StreamObserver<grpc.waterQuality.SampleResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCreateSampleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSampleMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.waterQuality.SampleRequest,
                grpc.waterQuality.SampleResponse>(
                  this, METHODID_CREATE_SAMPLE)))
          .build();
    }
  }

  /**
   */
  public static final class waterSampleServiceStub extends io.grpc.stub.AbstractStub<waterSampleServiceStub> {
    private waterSampleServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private waterSampleServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected waterSampleServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new waterSampleServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * bidirectional
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.waterQuality.SampleRequest> createSample(
        io.grpc.stub.StreamObserver<grpc.waterQuality.SampleResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCreateSampleMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class waterSampleServiceBlockingStub extends io.grpc.stub.AbstractStub<waterSampleServiceBlockingStub> {
    private waterSampleServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private waterSampleServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected waterSampleServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new waterSampleServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class waterSampleServiceFutureStub extends io.grpc.stub.AbstractStub<waterSampleServiceFutureStub> {
    private waterSampleServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private waterSampleServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected waterSampleServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new waterSampleServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CREATE_SAMPLE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final waterSampleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(waterSampleServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_CREATE_SAMPLE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createSample(
              (io.grpc.stub.StreamObserver<grpc.waterQuality.SampleResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class waterSampleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    waterSampleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.waterQuality.WaterQualityImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("waterSampleService");
    }
  }

  private static final class waterSampleServiceFileDescriptorSupplier
      extends waterSampleServiceBaseDescriptorSupplier {
    waterSampleServiceFileDescriptorSupplier() {}
  }

  private static final class waterSampleServiceMethodDescriptorSupplier
      extends waterSampleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    waterSampleServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (waterSampleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new waterSampleServiceFileDescriptorSupplier())
              .addMethod(getCreateSampleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
