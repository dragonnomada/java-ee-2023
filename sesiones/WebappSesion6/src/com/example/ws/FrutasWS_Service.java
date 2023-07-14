/**
 * FrutasWS_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public interface FrutasWS_Service extends javax.xml.rpc.Service {
    public java.lang.String getFrutasWSPortAddress();

    public com.example.ws.FrutasWS_PortType getFrutasWSPort() throws javax.xml.rpc.ServiceException;

    public com.example.ws.FrutasWS_PortType getFrutasWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
