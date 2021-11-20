package grpc.poluttionMonitoring;

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
    comments = "Source: medicalWaste.proto")
public final class medicalWasteServiceGrpc {

  private medicalWasteServiceGrpc() {}

  public static final String SERVICE_NAME = "medicalWasteService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.poluttionMonitoring.containsBagId,
      grpc.poluttionMonitoring.containsBagId> getGetBagIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBagId",
      requestType = grpc.poluttionMonitoring.containsBagId.class,
      responseType = grpc.poluttionMonitoring.containsBagId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.poluttionMonitoring.containsBagId,
      grpc.poluttionMonitoring.containsBagId> getGetBagIdMethod() {
    io.grpc.MethodDescriptor<grpc.poluttionMonitoring.containsBagId, grpc.poluttionMonitoring.containsBagId> getGetBagIdMethod;
    if ((getGetBagIdMethod = medicalWasteServiceGrpc.getGetBagIdMethod) == null) {
      synchronized (medicalWasteServiceGrpc.class) {
        if ((getGetBagIdMethod = medicalWasteServiceGrpc.getGetBagIdMethod) == null) {
          medicalWasteServiceGrpc.getGetBagIdMethod = getGetBagIdMethod = 
              io.grpc.MethodDescriptor.<grpc.poluttionMonitoring.containsBagId, grpc.poluttionMonitoring.containsBagId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "medicalWasteService", "GetBagId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.poluttionMonitoring.containsBagId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.poluttionMonitoring.containsBagId.getDefaultInstance()))
                  .setSchemaDescriptor(new medicalWasteServiceMethodDescriptorSupplier("GetBagId"))
                  .build();
          }
        }
     }
     return getGetBagIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static medicalWasteServiceStub newStub(io.grpc.Channel channel) {
    return new medicalWasteServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static medicalWasteServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new medicalWasteServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static medicalWasteServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new medicalWasteServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class medicalWasteServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void getBagId(grpc.poluttionMonitoring.containsBagId request,
        io.grpc.stub.StreamObserver<grpc.poluttionMonitoring.containsBagId> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBagIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetBagIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.poluttionMonitoring.containsBagId,
                grpc.poluttionMonitoring.containsBagId>(
                  this, METHODID_GET_BAG_ID)))
          .build();
    }
  }

  /**
   */
  public static final class medicalWasteServiceStub extends io.grpc.stub.AbstractStub<medicalWasteServiceStub> {
    private medicalWasteServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private medicalWasteServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected medicalWasteServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new medicalWasteServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void getBagId(grpc.poluttionMonitoring.containsBagId request,
        io.grpc.stub.StreamObserver<grpc.poluttionMonitoring.containsBagId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBagIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class medicalWasteServiceBlockingStub extends io.grpc.stub.AbstractStub<medicalWasteServiceBlockingStub> {
    private medicalWasteServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private medicalWasteServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected medicalWasteServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new medicalWasteServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public grpc.poluttionMonitoring.containsBagId getBagId(grpc.poluttionMonitoring.containsBagId request) {
      return blockingUnaryCall(
          getChannel(), getGetBagIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class medicalWasteServiceFutureStub extends io.grpc.stub.AbstractStub<medicalWasteServiceFutureStub> {
    private medicalWasteServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private medicalWasteServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected medicalWasteServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new medicalWasteServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.poluttionMonitoring.containsBagId> getBagId(
        grpc.poluttionMonitoring.containsBagId request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBagIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BAG_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final medicalWasteServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(medicalWasteServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BAG_ID:
          serviceImpl.getBagId((grpc.poluttionMonitoring.containsBagId) request,
              (io.grpc.stub.StreamObserver<grpc.poluttionMonitoring.containsBagId>) responseObserver);
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

  private static abstract class medicalWasteServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    medicalWasteServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.poluttionMonitoring.MedicalWasteImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("medicalWasteService");
    }
  }

  private static final class medicalWasteServiceFileDescriptorSupplier
      extends medicalWasteServiceBaseDescriptorSupplier {
    medicalWasteServiceFileDescriptorSupplier() {}
  }

  private static final class medicalWasteServiceMethodDescriptorSupplier
      extends medicalWasteServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    medicalWasteServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (medicalWasteServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new medicalWasteServiceFileDescriptorSupplier())
              .addMethod(getGetBagIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
