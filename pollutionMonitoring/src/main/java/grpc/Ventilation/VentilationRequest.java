// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ventilation.proto

package grpc.Ventilation;

/**
 * Protobuf type {@code VentilationRequest}
 */
public  final class VentilationRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:VentilationRequest)
    VentilationRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VentilationRequest.newBuilder() to construct.
  private VentilationRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VentilationRequest() {
    loc_ = "";
    air_ = false;
    temp_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VentilationRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            loc_ = s;
            break;
          }
          case 16: {

            air_ = input.readBool();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            temp_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.Ventilation.VentilationImpl.internal_static_VentilationRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.Ventilation.VentilationImpl.internal_static_VentilationRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.Ventilation.VentilationRequest.class, grpc.Ventilation.VentilationRequest.Builder.class);
  }

  public static final int LOC_FIELD_NUMBER = 1;
  private volatile java.lang.Object loc_;
  /**
   * <code>string loc = 1;</code>
   */
  public java.lang.String getLoc() {
    java.lang.Object ref = loc_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      loc_ = s;
      return s;
    }
  }
  /**
   * <code>string loc = 1;</code>
   */
  public com.google.protobuf.ByteString
      getLocBytes() {
    java.lang.Object ref = loc_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      loc_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AIR_FIELD_NUMBER = 2;
  private boolean air_;
  /**
   * <code>bool air = 2;</code>
   */
  public boolean getAir() {
    return air_;
  }

  public static final int TEMP_FIELD_NUMBER = 3;
  private volatile java.lang.Object temp_;
  /**
   * <code>string temp = 3;</code>
   */
  public java.lang.String getTemp() {
    java.lang.Object ref = temp_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      temp_ = s;
      return s;
    }
  }
  /**
   * <code>string temp = 3;</code>
   */
  public com.google.protobuf.ByteString
      getTempBytes() {
    java.lang.Object ref = temp_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      temp_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getLocBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, loc_);
    }
    if (air_ != false) {
      output.writeBool(2, air_);
    }
    if (!getTempBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, temp_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getLocBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, loc_);
    }
    if (air_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, air_);
    }
    if (!getTempBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, temp_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.Ventilation.VentilationRequest)) {
      return super.equals(obj);
    }
    grpc.Ventilation.VentilationRequest other = (grpc.Ventilation.VentilationRequest) obj;

    boolean result = true;
    result = result && getLoc()
        .equals(other.getLoc());
    result = result && (getAir()
        == other.getAir());
    result = result && getTemp()
        .equals(other.getTemp());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + LOC_FIELD_NUMBER;
    hash = (53 * hash) + getLoc().hashCode();
    hash = (37 * hash) + AIR_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAir());
    hash = (37 * hash) + TEMP_FIELD_NUMBER;
    hash = (53 * hash) + getTemp().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.Ventilation.VentilationRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Ventilation.VentilationRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Ventilation.VentilationRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Ventilation.VentilationRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Ventilation.VentilationRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Ventilation.VentilationRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Ventilation.VentilationRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.Ventilation.VentilationRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.Ventilation.VentilationRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.Ventilation.VentilationRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.Ventilation.VentilationRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.Ventilation.VentilationRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.Ventilation.VentilationRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code VentilationRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:VentilationRequest)
      grpc.Ventilation.VentilationRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.Ventilation.VentilationImpl.internal_static_VentilationRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.Ventilation.VentilationImpl.internal_static_VentilationRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.Ventilation.VentilationRequest.class, grpc.Ventilation.VentilationRequest.Builder.class);
    }

    // Construct using grpc.Ventilation.VentilationRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      loc_ = "";

      air_ = false;

      temp_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.Ventilation.VentilationImpl.internal_static_VentilationRequest_descriptor;
    }

    @java.lang.Override
    public grpc.Ventilation.VentilationRequest getDefaultInstanceForType() {
      return grpc.Ventilation.VentilationRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.Ventilation.VentilationRequest build() {
      grpc.Ventilation.VentilationRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.Ventilation.VentilationRequest buildPartial() {
      grpc.Ventilation.VentilationRequest result = new grpc.Ventilation.VentilationRequest(this);
      result.loc_ = loc_;
      result.air_ = air_;
      result.temp_ = temp_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.Ventilation.VentilationRequest) {
        return mergeFrom((grpc.Ventilation.VentilationRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.Ventilation.VentilationRequest other) {
      if (other == grpc.Ventilation.VentilationRequest.getDefaultInstance()) return this;
      if (!other.getLoc().isEmpty()) {
        loc_ = other.loc_;
        onChanged();
      }
      if (other.getAir() != false) {
        setAir(other.getAir());
      }
      if (!other.getTemp().isEmpty()) {
        temp_ = other.temp_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.Ventilation.VentilationRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.Ventilation.VentilationRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object loc_ = "";
    /**
     * <code>string loc = 1;</code>
     */
    public java.lang.String getLoc() {
      java.lang.Object ref = loc_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        loc_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string loc = 1;</code>
     */
    public com.google.protobuf.ByteString
        getLocBytes() {
      java.lang.Object ref = loc_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        loc_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string loc = 1;</code>
     */
    public Builder setLoc(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      loc_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string loc = 1;</code>
     */
    public Builder clearLoc() {
      
      loc_ = getDefaultInstance().getLoc();
      onChanged();
      return this;
    }
    /**
     * <code>string loc = 1;</code>
     */
    public Builder setLocBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      loc_ = value;
      onChanged();
      return this;
    }

    private boolean air_ ;
    /**
     * <code>bool air = 2;</code>
     */
    public boolean getAir() {
      return air_;
    }
    /**
     * <code>bool air = 2;</code>
     */
    public Builder setAir(boolean value) {
      
      air_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool air = 2;</code>
     */
    public Builder clearAir() {
      
      air_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object temp_ = "";
    /**
     * <code>string temp = 3;</code>
     */
    public java.lang.String getTemp() {
      java.lang.Object ref = temp_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        temp_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string temp = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTempBytes() {
      java.lang.Object ref = temp_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        temp_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string temp = 3;</code>
     */
    public Builder setTemp(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      temp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string temp = 3;</code>
     */
    public Builder clearTemp() {
      
      temp_ = getDefaultInstance().getTemp();
      onChanged();
      return this;
    }
    /**
     * <code>string temp = 3;</code>
     */
    public Builder setTempBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      temp_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:VentilationRequest)
  }

  // @@protoc_insertion_point(class_scope:VentilationRequest)
  private static final grpc.Ventilation.VentilationRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.Ventilation.VentilationRequest();
  }

  public static grpc.Ventilation.VentilationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VentilationRequest>
      PARSER = new com.google.protobuf.AbstractParser<VentilationRequest>() {
    @java.lang.Override
    public VentilationRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VentilationRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VentilationRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VentilationRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.Ventilation.VentilationRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
