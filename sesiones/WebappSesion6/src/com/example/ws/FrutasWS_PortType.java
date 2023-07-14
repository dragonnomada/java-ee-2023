/**
 * FrutasWS_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public interface FrutasWS_PortType extends java.rmi.Remote {
    public com.example.ws.Fruta deleteFruta(long id) throws java.rmi.RemoteException;
    public com.example.ws.Fruta updateFruta(long id, java.lang.String nombre, double precio, double peso, int existencias) throws java.rmi.RemoteException;
    public com.example.ws.Fruta getFrutaById(long id) throws java.rmi.RemoteException;
    public com.example.ws.Fruta[] getAllFrutas() throws java.rmi.RemoteException;
    public com.example.ws.Fruta addFruta(java.lang.String nombre, double precio) throws java.rmi.RemoteException;
}
