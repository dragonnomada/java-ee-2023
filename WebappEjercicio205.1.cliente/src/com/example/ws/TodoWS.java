/**
 * TodoWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public interface TodoWS extends javax.xml.rpc.Service {
    public java.lang.String getTodoWebServicePortAddress();

    public com.example.ws.TodoWebService getTodoWebServicePort() throws javax.xml.rpc.ServiceException;

    public com.example.ws.TodoWebService getTodoWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
