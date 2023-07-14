/**
 * Todo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public class Todo  implements java.io.Serializable {
    private java.lang.String title;

    private java.lang.Boolean isChecked;

    private long id;  // attribute

    private java.util.Calendar createdAt;  // attribute

    public Todo() {
    }

    public Todo(
           java.lang.String title,
           java.lang.Boolean isChecked,
           long id,
           java.util.Calendar createdAt) {
           this.title = title;
           this.isChecked = isChecked;
           this.id = id;
           this.createdAt = createdAt;
    }


    /**
     * Gets the title value for this Todo.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Todo.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the isChecked value for this Todo.
     * 
     * @return isChecked
     */
    public java.lang.Boolean getIsChecked() {
        return isChecked;
    }


    /**
     * Sets the isChecked value for this Todo.
     * 
     * @param isChecked
     */
    public void setIsChecked(java.lang.Boolean isChecked) {
        this.isChecked = isChecked;
    }


    /**
     * Gets the id value for this Todo.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Todo.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the createdAt value for this Todo.
     * 
     * @return createdAt
     */
    public java.util.Calendar getCreatedAt() {
        return createdAt;
    }


    /**
     * Sets the createdAt value for this Todo.
     * 
     * @param createdAt
     */
    public void setCreatedAt(java.util.Calendar createdAt) {
        this.createdAt = createdAt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Todo)) return false;
        Todo other = (Todo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.isChecked==null && other.getIsChecked()==null) || 
             (this.isChecked!=null &&
              this.isChecked.equals(other.getIsChecked()))) &&
            this.id == other.getId() &&
            ((this.createdAt==null && other.getCreatedAt()==null) || 
             (this.createdAt!=null &&
              this.createdAt.equals(other.getCreatedAt())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getIsChecked() != null) {
            _hashCode += getIsChecked().hashCode();
        }
        _hashCode += new Long(getId()).hashCode();
        if (getCreatedAt() != null) {
            _hashCode += getCreatedAt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Todo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.example.com/", "todo"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("createdAt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "createdAt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isChecked");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isChecked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
