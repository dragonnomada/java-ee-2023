/**
 * TodoWS_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public interface TodoWS_PortType extends java.rmi.Remote {
    public com.example.ws.Todo[] getTodos() throws java.rmi.RemoteException;
    public com.example.ws.Todo addTodo(java.lang.String title, boolean checked) throws java.rmi.RemoteException;
}
