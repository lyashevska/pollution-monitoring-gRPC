// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ventilation.proto

package grpc.Ventilation;

public final class VentilationImpl {
  private VentilationImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VentilationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VentilationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VentilationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VentilationResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021ventilation.proto\"<\n\022VentilationReques" +
      "t\022\013\n\003loc\030\001 \001(\t\022\013\n\003air\030\002 \001(\010\022\014\n\004temp\030\003 \001(" +
      "\t\"W\n\023VentilationResponse\022\016\n\006roomId\030\001 \001(\t" +
      "\022\014\n\004temp\030\002 \001(\t\022\014\n\004date\030\003 \001(\t\022\024\n\014timeSamp" +
      "ling\030\004 \001(\t2[\n\022VentilationService\022E\n\026send" +
      "VentilationRequest\022\023.VentilationRequest\032" +
      "\024.VentilationResponse0\001B%\n\020grpc.Ventilat" +
      "ionB\017VentilationImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_VentilationRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_VentilationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VentilationRequest_descriptor,
        new java.lang.String[] { "Loc", "Air", "Temp", });
    internal_static_VentilationResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_VentilationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VentilationResponse_descriptor,
        new java.lang.String[] { "RoomId", "Temp", "Date", "TimeSampling", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
