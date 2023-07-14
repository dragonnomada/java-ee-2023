/**
 * HelloWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public interface HelloWebService extends java.rmi.Remote {
    public java.lang.String sayHello() throws java.rmi.RemoteException;
    public java.lang.String generarReporte(double min, double max) throws java.rmi.RemoteException;
}
