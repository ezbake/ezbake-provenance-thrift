/*   Copyright (C) 2013-2014 Computer Sciences Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package ezbake.services.provenance.thrift;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DerivedResult implements org.apache.thrift.TBase<DerivedResult, DerivedResult._Fields>, java.io.Serializable, Cloneable, Comparable<DerivedResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DerivedResult");

  private static final org.apache.thrift.protocol.TField DERIVED_DOCS_FIELD_DESC = new org.apache.thrift.protocol.TField("derivedDocs", org.apache.thrift.protocol.TType.SET, (short)1);
  private static final org.apache.thrift.protocol.TField URIS_NOT_FOUND_FIELD_DESC = new org.apache.thrift.protocol.TField("urisNotFound", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField IMMEDIATE_CHILDREN_FIELD_DESC = new org.apache.thrift.protocol.TField("immediateChildren", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DerivedResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DerivedResultTupleSchemeFactory());
  }

  public Set<Long> derivedDocs; // required
  public List<String> urisNotFound; // required
  public List<Long> immediateChildren; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DERIVED_DOCS((short)1, "derivedDocs"),
    URIS_NOT_FOUND((short)2, "urisNotFound"),
    IMMEDIATE_CHILDREN((short)3, "immediateChildren");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DERIVED_DOCS
          return DERIVED_DOCS;
        case 2: // URIS_NOT_FOUND
          return URIS_NOT_FOUND;
        case 3: // IMMEDIATE_CHILDREN
          return IMMEDIATE_CHILDREN;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private _Fields optionals[] = {_Fields.IMMEDIATE_CHILDREN};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DERIVED_DOCS, new org.apache.thrift.meta_data.FieldMetaData("derivedDocs", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.URIS_NOT_FOUND, new org.apache.thrift.meta_data.FieldMetaData("urisNotFound", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.IMMEDIATE_CHILDREN, new org.apache.thrift.meta_data.FieldMetaData("immediateChildren", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DerivedResult.class, metaDataMap);
  }

  public DerivedResult() {
  }

  public DerivedResult(
    Set<Long> derivedDocs,
    List<String> urisNotFound)
  {
    this();
    this.derivedDocs = derivedDocs;
    this.urisNotFound = urisNotFound;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DerivedResult(DerivedResult other) {
    if (other.isSetDerivedDocs()) {
      Set<Long> __this__derivedDocs = new HashSet<Long>(other.derivedDocs);
      this.derivedDocs = __this__derivedDocs;
    }
    if (other.isSetUrisNotFound()) {
      List<String> __this__urisNotFound = new ArrayList<String>(other.urisNotFound);
      this.urisNotFound = __this__urisNotFound;
    }
    if (other.isSetImmediateChildren()) {
      List<Long> __this__immediateChildren = new ArrayList<Long>(other.immediateChildren);
      this.immediateChildren = __this__immediateChildren;
    }
  }

  public DerivedResult deepCopy() {
    return new DerivedResult(this);
  }

  @Override
  public void clear() {
    this.derivedDocs = null;
    this.urisNotFound = null;
    this.immediateChildren = null;
  }

  public int getDerivedDocsSize() {
    return (this.derivedDocs == null) ? 0 : this.derivedDocs.size();
  }

  public java.util.Iterator<Long> getDerivedDocsIterator() {
    return (this.derivedDocs == null) ? null : this.derivedDocs.iterator();
  }

  public void addToDerivedDocs(long elem) {
    if (this.derivedDocs == null) {
      this.derivedDocs = new HashSet<Long>();
    }
    this.derivedDocs.add(elem);
  }

  public Set<Long> getDerivedDocs() {
    return this.derivedDocs;
  }

  public DerivedResult setDerivedDocs(Set<Long> derivedDocs) {
    this.derivedDocs = derivedDocs;
    return this;
  }

  public void unsetDerivedDocs() {
    this.derivedDocs = null;
  }

  /** Returns true if field derivedDocs is set (has been assigned a value) and false otherwise */
  public boolean isSetDerivedDocs() {
    return this.derivedDocs != null;
  }

  public void setDerivedDocsIsSet(boolean value) {
    if (!value) {
      this.derivedDocs = null;
    }
  }

  public int getUrisNotFoundSize() {
    return (this.urisNotFound == null) ? 0 : this.urisNotFound.size();
  }

  public java.util.Iterator<String> getUrisNotFoundIterator() {
    return (this.urisNotFound == null) ? null : this.urisNotFound.iterator();
  }

  public void addToUrisNotFound(String elem) {
    if (this.urisNotFound == null) {
      this.urisNotFound = new ArrayList<String>();
    }
    this.urisNotFound.add(elem);
  }

  public List<String> getUrisNotFound() {
    return this.urisNotFound;
  }

  public DerivedResult setUrisNotFound(List<String> urisNotFound) {
    this.urisNotFound = urisNotFound;
    return this;
  }

  public void unsetUrisNotFound() {
    this.urisNotFound = null;
  }

  /** Returns true if field urisNotFound is set (has been assigned a value) and false otherwise */
  public boolean isSetUrisNotFound() {
    return this.urisNotFound != null;
  }

  public void setUrisNotFoundIsSet(boolean value) {
    if (!value) {
      this.urisNotFound = null;
    }
  }

  public int getImmediateChildrenSize() {
    return (this.immediateChildren == null) ? 0 : this.immediateChildren.size();
  }

  public java.util.Iterator<Long> getImmediateChildrenIterator() {
    return (this.immediateChildren == null) ? null : this.immediateChildren.iterator();
  }

  public void addToImmediateChildren(long elem) {
    if (this.immediateChildren == null) {
      this.immediateChildren = new ArrayList<Long>();
    }
    this.immediateChildren.add(elem);
  }

  public List<Long> getImmediateChildren() {
    return this.immediateChildren;
  }

  public DerivedResult setImmediateChildren(List<Long> immediateChildren) {
    this.immediateChildren = immediateChildren;
    return this;
  }

  public void unsetImmediateChildren() {
    this.immediateChildren = null;
  }

  /** Returns true if field immediateChildren is set (has been assigned a value) and false otherwise */
  public boolean isSetImmediateChildren() {
    return this.immediateChildren != null;
  }

  public void setImmediateChildrenIsSet(boolean value) {
    if (!value) {
      this.immediateChildren = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DERIVED_DOCS:
      if (value == null) {
        unsetDerivedDocs();
      } else {
        setDerivedDocs((Set<Long>)value);
      }
      break;

    case URIS_NOT_FOUND:
      if (value == null) {
        unsetUrisNotFound();
      } else {
        setUrisNotFound((List<String>)value);
      }
      break;

    case IMMEDIATE_CHILDREN:
      if (value == null) {
        unsetImmediateChildren();
      } else {
        setImmediateChildren((List<Long>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DERIVED_DOCS:
      return getDerivedDocs();

    case URIS_NOT_FOUND:
      return getUrisNotFound();

    case IMMEDIATE_CHILDREN:
      return getImmediateChildren();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DERIVED_DOCS:
      return isSetDerivedDocs();
    case URIS_NOT_FOUND:
      return isSetUrisNotFound();
    case IMMEDIATE_CHILDREN:
      return isSetImmediateChildren();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DerivedResult)
      return this.equals((DerivedResult)that);
    return false;
  }

  public boolean equals(DerivedResult that) {
    if (that == null)
      return false;

    boolean this_present_derivedDocs = true && this.isSetDerivedDocs();
    boolean that_present_derivedDocs = true && that.isSetDerivedDocs();
    if (this_present_derivedDocs || that_present_derivedDocs) {
      if (!(this_present_derivedDocs && that_present_derivedDocs))
        return false;
      if (!this.derivedDocs.equals(that.derivedDocs))
        return false;
    }

    boolean this_present_urisNotFound = true && this.isSetUrisNotFound();
    boolean that_present_urisNotFound = true && that.isSetUrisNotFound();
    if (this_present_urisNotFound || that_present_urisNotFound) {
      if (!(this_present_urisNotFound && that_present_urisNotFound))
        return false;
      if (!this.urisNotFound.equals(that.urisNotFound))
        return false;
    }

    boolean this_present_immediateChildren = true && this.isSetImmediateChildren();
    boolean that_present_immediateChildren = true && that.isSetImmediateChildren();
    if (this_present_immediateChildren || that_present_immediateChildren) {
      if (!(this_present_immediateChildren && that_present_immediateChildren))
        return false;
      if (!this.immediateChildren.equals(that.immediateChildren))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_derivedDocs = true && (isSetDerivedDocs());
    builder.append(present_derivedDocs);
    if (present_derivedDocs)
      builder.append(derivedDocs);

    boolean present_urisNotFound = true && (isSetUrisNotFound());
    builder.append(present_urisNotFound);
    if (present_urisNotFound)
      builder.append(urisNotFound);

    boolean present_immediateChildren = true && (isSetImmediateChildren());
    builder.append(present_immediateChildren);
    if (present_immediateChildren)
      builder.append(immediateChildren);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(DerivedResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDerivedDocs()).compareTo(other.isSetDerivedDocs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDerivedDocs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.derivedDocs, other.derivedDocs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUrisNotFound()).compareTo(other.isSetUrisNotFound());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUrisNotFound()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.urisNotFound, other.urisNotFound);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetImmediateChildren()).compareTo(other.isSetImmediateChildren());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetImmediateChildren()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.immediateChildren, other.immediateChildren);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("DerivedResult(");
    boolean first = true;

    sb.append("derivedDocs:");
    if (this.derivedDocs == null) {
      sb.append("null");
    } else {
      sb.append(this.derivedDocs);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("urisNotFound:");
    if (this.urisNotFound == null) {
      sb.append("null");
    } else {
      sb.append(this.urisNotFound);
    }
    first = false;
    if (isSetImmediateChildren()) {
      if (!first) sb.append(", ");
      sb.append("immediateChildren:");
      if (this.immediateChildren == null) {
        sb.append("null");
      } else {
        sb.append(this.immediateChildren);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (derivedDocs == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'derivedDocs' was not present! Struct: " + toString());
    }
    if (urisNotFound == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'urisNotFound' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DerivedResultStandardSchemeFactory implements SchemeFactory {
    public DerivedResultStandardScheme getScheme() {
      return new DerivedResultStandardScheme();
    }
  }

  private static class DerivedResultStandardScheme extends StandardScheme<DerivedResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DerivedResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DERIVED_DOCS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set8 = iprot.readSetBegin();
                struct.derivedDocs = new HashSet<Long>(2*_set8.size);
                for (int _i9 = 0; _i9 < _set8.size; ++_i9)
                {
                  long _elem10;
                  _elem10 = iprot.readI64();
                  struct.derivedDocs.add(_elem10);
                }
                iprot.readSetEnd();
              }
              struct.setDerivedDocsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // URIS_NOT_FOUND
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list11 = iprot.readListBegin();
                struct.urisNotFound = new ArrayList<String>(_list11.size);
                for (int _i12 = 0; _i12 < _list11.size; ++_i12)
                {
                  String _elem13;
                  _elem13 = iprot.readString();
                  struct.urisNotFound.add(_elem13);
                }
                iprot.readListEnd();
              }
              struct.setUrisNotFoundIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // IMMEDIATE_CHILDREN
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list14 = iprot.readListBegin();
                struct.immediateChildren = new ArrayList<Long>(_list14.size);
                for (int _i15 = 0; _i15 < _list14.size; ++_i15)
                {
                  long _elem16;
                  _elem16 = iprot.readI64();
                  struct.immediateChildren.add(_elem16);
                }
                iprot.readListEnd();
              }
              struct.setImmediateChildrenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DerivedResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.derivedDocs != null) {
        oprot.writeFieldBegin(DERIVED_DOCS_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I64, struct.derivedDocs.size()));
          for (long _iter17 : struct.derivedDocs)
          {
            oprot.writeI64(_iter17);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.urisNotFound != null) {
        oprot.writeFieldBegin(URIS_NOT_FOUND_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.urisNotFound.size()));
          for (String _iter18 : struct.urisNotFound)
          {
            oprot.writeString(_iter18);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.immediateChildren != null) {
        if (struct.isSetImmediateChildren()) {
          oprot.writeFieldBegin(IMMEDIATE_CHILDREN_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, struct.immediateChildren.size()));
            for (long _iter19 : struct.immediateChildren)
            {
              oprot.writeI64(_iter19);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DerivedResultTupleSchemeFactory implements SchemeFactory {
    public DerivedResultTupleScheme getScheme() {
      return new DerivedResultTupleScheme();
    }
  }

  private static class DerivedResultTupleScheme extends TupleScheme<DerivedResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DerivedResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.derivedDocs.size());
        for (long _iter20 : struct.derivedDocs)
        {
          oprot.writeI64(_iter20);
        }
      }
      {
        oprot.writeI32(struct.urisNotFound.size());
        for (String _iter21 : struct.urisNotFound)
        {
          oprot.writeString(_iter21);
        }
      }
      BitSet optionals = new BitSet();
      if (struct.isSetImmediateChildren()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetImmediateChildren()) {
        {
          oprot.writeI32(struct.immediateChildren.size());
          for (long _iter22 : struct.immediateChildren)
          {
            oprot.writeI64(_iter22);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DerivedResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TSet _set23 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I64, iprot.readI32());
        struct.derivedDocs = new HashSet<Long>(2*_set23.size);
        for (int _i24 = 0; _i24 < _set23.size; ++_i24)
        {
          long _elem25;
          _elem25 = iprot.readI64();
          struct.derivedDocs.add(_elem25);
        }
      }
      struct.setDerivedDocsIsSet(true);
      {
        org.apache.thrift.protocol.TList _list26 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
        struct.urisNotFound = new ArrayList<String>(_list26.size);
        for (int _i27 = 0; _i27 < _list26.size; ++_i27)
        {
          String _elem28;
          _elem28 = iprot.readString();
          struct.urisNotFound.add(_elem28);
        }
      }
      struct.setUrisNotFoundIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list29 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
          struct.immediateChildren = new ArrayList<Long>(_list29.size);
          for (int _i30 = 0; _i30 < _list29.size; ++_i30)
          {
            long _elem31;
            _elem31 = iprot.readI64();
            struct.immediateChildren.add(_elem31);
          }
        }
        struct.setImmediateChildrenIsSet(true);
      }
    }
  }

}
