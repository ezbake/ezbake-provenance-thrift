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

public class ResultsAndContinuation implements org.apache.thrift.TBase<ResultsAndContinuation, ResultsAndContinuation._Fields>, java.io.Serializable, Cloneable, Comparable<ResultsAndContinuation> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ResultsAndContinuation");

  private static final org.apache.thrift.protocol.TField RESULTS_FIELD_DESC = new org.apache.thrift.protocol.TField("results", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField CONTINUATION_POINT_FIELD_DESC = new org.apache.thrift.protocol.TField("continuationPoint", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ResultsAndContinuationStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ResultsAndContinuationTupleSchemeFactory());
  }

  public List<String> results; // required
  public AccumuloContinuationPoint continuationPoint; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESULTS((short)1, "results"),
    CONTINUATION_POINT((short)2, "continuationPoint");

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
        case 1: // RESULTS
          return RESULTS;
        case 2: // CONTINUATION_POINT
          return CONTINUATION_POINT;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULTS, new org.apache.thrift.meta_data.FieldMetaData("results", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.CONTINUATION_POINT, new org.apache.thrift.meta_data.FieldMetaData("continuationPoint", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AccumuloContinuationPoint.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ResultsAndContinuation.class, metaDataMap);
  }

  public ResultsAndContinuation() {
  }

  public ResultsAndContinuation(
    List<String> results,
    AccumuloContinuationPoint continuationPoint)
  {
    this();
    this.results = results;
    this.continuationPoint = continuationPoint;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ResultsAndContinuation(ResultsAndContinuation other) {
    if (other.isSetResults()) {
      List<String> __this__results = new ArrayList<String>(other.results);
      this.results = __this__results;
    }
    if (other.isSetContinuationPoint()) {
      this.continuationPoint = new AccumuloContinuationPoint(other.continuationPoint);
    }
  }

  public ResultsAndContinuation deepCopy() {
    return new ResultsAndContinuation(this);
  }

  @Override
  public void clear() {
    this.results = null;
    this.continuationPoint = null;
  }

  public int getResultsSize() {
    return (this.results == null) ? 0 : this.results.size();
  }

  public java.util.Iterator<String> getResultsIterator() {
    return (this.results == null) ? null : this.results.iterator();
  }

  public void addToResults(String elem) {
    if (this.results == null) {
      this.results = new ArrayList<String>();
    }
    this.results.add(elem);
  }

  public List<String> getResults() {
    return this.results;
  }

  public ResultsAndContinuation setResults(List<String> results) {
    this.results = results;
    return this;
  }

  public void unsetResults() {
    this.results = null;
  }

  /** Returns true if field results is set (has been assigned a value) and false otherwise */
  public boolean isSetResults() {
    return this.results != null;
  }

  public void setResultsIsSet(boolean value) {
    if (!value) {
      this.results = null;
    }
  }

  public AccumuloContinuationPoint getContinuationPoint() {
    return this.continuationPoint;
  }

  public ResultsAndContinuation setContinuationPoint(AccumuloContinuationPoint continuationPoint) {
    this.continuationPoint = continuationPoint;
    return this;
  }

  public void unsetContinuationPoint() {
    this.continuationPoint = null;
  }

  /** Returns true if field continuationPoint is set (has been assigned a value) and false otherwise */
  public boolean isSetContinuationPoint() {
    return this.continuationPoint != null;
  }

  public void setContinuationPointIsSet(boolean value) {
    if (!value) {
      this.continuationPoint = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESULTS:
      if (value == null) {
        unsetResults();
      } else {
        setResults((List<String>)value);
      }
      break;

    case CONTINUATION_POINT:
      if (value == null) {
        unsetContinuationPoint();
      } else {
        setContinuationPoint((AccumuloContinuationPoint)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULTS:
      return getResults();

    case CONTINUATION_POINT:
      return getContinuationPoint();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESULTS:
      return isSetResults();
    case CONTINUATION_POINT:
      return isSetContinuationPoint();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ResultsAndContinuation)
      return this.equals((ResultsAndContinuation)that);
    return false;
  }

  public boolean equals(ResultsAndContinuation that) {
    if (that == null)
      return false;

    boolean this_present_results = true && this.isSetResults();
    boolean that_present_results = true && that.isSetResults();
    if (this_present_results || that_present_results) {
      if (!(this_present_results && that_present_results))
        return false;
      if (!this.results.equals(that.results))
        return false;
    }

    boolean this_present_continuationPoint = true && this.isSetContinuationPoint();
    boolean that_present_continuationPoint = true && that.isSetContinuationPoint();
    if (this_present_continuationPoint || that_present_continuationPoint) {
      if (!(this_present_continuationPoint && that_present_continuationPoint))
        return false;
      if (!this.continuationPoint.equals(that.continuationPoint))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_results = true && (isSetResults());
    builder.append(present_results);
    if (present_results)
      builder.append(results);

    boolean present_continuationPoint = true && (isSetContinuationPoint());
    builder.append(present_continuationPoint);
    if (present_continuationPoint)
      builder.append(continuationPoint);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(ResultsAndContinuation other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResults()).compareTo(other.isSetResults());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResults()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.results, other.results);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetContinuationPoint()).compareTo(other.isSetContinuationPoint());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContinuationPoint()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.continuationPoint, other.continuationPoint);
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
    StringBuilder sb = new StringBuilder("ResultsAndContinuation(");
    boolean first = true;

    sb.append("results:");
    if (this.results == null) {
      sb.append("null");
    } else {
      sb.append(this.results);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("continuationPoint:");
    if (this.continuationPoint == null) {
      sb.append("null");
    } else {
      sb.append(this.continuationPoint);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (results == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'results' was not present! Struct: " + toString());
    }
    if (continuationPoint == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'continuationPoint' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (continuationPoint != null) {
      continuationPoint.validate();
    }
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

  private static class ResultsAndContinuationStandardSchemeFactory implements SchemeFactory {
    public ResultsAndContinuationStandardScheme getScheme() {
      return new ResultsAndContinuationStandardScheme();
    }
  }

  private static class ResultsAndContinuationStandardScheme extends StandardScheme<ResultsAndContinuation> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ResultsAndContinuation struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RESULTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.results = new ArrayList<String>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  String _elem2;
                  _elem2 = iprot.readString();
                  struct.results.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setResultsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CONTINUATION_POINT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.continuationPoint = new AccumuloContinuationPoint();
              struct.continuationPoint.read(iprot);
              struct.setContinuationPointIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ResultsAndContinuation struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.results != null) {
        oprot.writeFieldBegin(RESULTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.results.size()));
          for (String _iter3 : struct.results)
          {
            oprot.writeString(_iter3);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.continuationPoint != null) {
        oprot.writeFieldBegin(CONTINUATION_POINT_FIELD_DESC);
        struct.continuationPoint.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ResultsAndContinuationTupleSchemeFactory implements SchemeFactory {
    public ResultsAndContinuationTupleScheme getScheme() {
      return new ResultsAndContinuationTupleScheme();
    }
  }

  private static class ResultsAndContinuationTupleScheme extends TupleScheme<ResultsAndContinuation> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ResultsAndContinuation struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.results.size());
        for (String _iter4 : struct.results)
        {
          oprot.writeString(_iter4);
        }
      }
      struct.continuationPoint.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ResultsAndContinuation struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
        struct.results = new ArrayList<String>(_list5.size);
        for (int _i6 = 0; _i6 < _list5.size; ++_i6)
        {
          String _elem7;
          _elem7 = iprot.readString();
          struct.results.add(_elem7);
        }
      }
      struct.setResultsIsSet(true);
      struct.continuationPoint = new AccumuloContinuationPoint();
      struct.continuationPoint.read(iprot);
      struct.setContinuationPointIsSet(true);
    }
  }

}

