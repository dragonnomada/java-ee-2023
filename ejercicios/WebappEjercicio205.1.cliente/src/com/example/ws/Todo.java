/**
 * Todo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public class Todo  implements java.io.Serializable {
    private java.util.Calendar createdAt;

    private java.lang.String title;

    private java.util.Calendar updatedAt;

    private boolean isChecked;  // attribute

    private long id;  // attribute

    public Todo() {
    }

    public Todo(
           java.util.Calendar createdAt,
           java.lang.String title,
           java.util.Calendar updatedAt,
           boolean isChecked,
           long id) {
           this.createdAt = createdAt;
           this.title = title;
           this.updatedAt = updatedAt;
           this.isChecked = isChecked;
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
     * Gets the updatedAt value for this Todo.
     * 
     * @return updatedAt
     */
    public java.util.Calendar getUpdatedAt() {
        return updatedAt;
    }


    /**
     * Sets the updatedAt value for this Todo.
     * 
     * @param updatedAt
     */
    public void setUpdatedAt(java.util.Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }


    /**
     * Gets the isChecked value for this Todo.
     * 
     * @return isChecked
     */
    public boolean isIsChecked() {
        return isChecked;
    }


    /**
     * Sets the isChecked value for this Todo.
     * 
     * @param isChecked
     */
    public void setIsChecked(boolean isChecked) {
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
            ((this.createdAt==null && other.getCreatedAt()==null) || 
             (this.createdAt!=null &&
              this.createdAt.equals(other.getCreatedAt()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.updatedAt==null && other.getUpdatedAt()==null) || 
             (this.updatedAt!=null &&
              this.updatedAt.equals(other.getUpdatedAt()))) &&
            this.isChecked == other.isIsChecked() &&
            this.id == other.getId();
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
        if (getCreatedAt() != null) {
            _hashCode += getCreatedAt().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getUpdatedAt() != null) {
            _hashCode += getUpdatedAt().hashCode();
        }
        _hashCode += (isIsChecked() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += new Long(getId()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Todo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.example.com/", "todo"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("isChecked");
        attrField.setXmlName(new javax.xml.namespace.QName("", "isChecked"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdAt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createdAt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updatedAt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updatedAt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
