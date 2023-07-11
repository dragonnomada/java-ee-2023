/**
 * TodoWS_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public interface TodoWS_Service extends javax.xml.rpc.Service {
    public java.lang.String getTodoWSPortAddress();

    public com.example.ws.TodoWS_PortType getTodoWSPort() throws javax.xml.rpc.ServiceException;

    public com.example.ws.TodoWS_PortType getTodoWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
