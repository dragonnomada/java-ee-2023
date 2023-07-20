/**
 * HelloWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public interface HelloWS extends javax.xml.rpc.Service {
    public java.lang.String getHelloWebServicePortAddress();

    public com.example.ws.HelloWebService getHelloWebServicePort() throws javax.xml.rpc.ServiceException;

    public com.example.ws.HelloWebService getHelloWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
