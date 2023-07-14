/**
 * HelloWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public class HelloWSLocator extends org.apache.axis.client.Service implements com.example.ws.HelloWS {

    public HelloWSLocator() {
    }


    public HelloWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloWebServicePort
    private java.lang.String HelloWebServicePort_address = "http://localhost:8080/WebappSesion8/HelloWS";

    public java.lang.String getHelloWebServicePortAddress() {
        return HelloWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloWebServicePortWSDDServiceName = "HelloWebServicePort";

    public java.lang.String getHelloWebServicePortWSDDServiceName() {
        return HelloWebServicePortWSDDServiceName;
    }

    public void setHelloWebServicePortWSDDServiceName(java.lang.String name) {
        HelloWebServicePortWSDDServiceName = name;
    }

    public com.example.ws.HelloWebService getHelloWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloWebServicePort(endpoint);
    }

    public com.example.ws.HelloWebService getHelloWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.example.ws.HelloWebServicePortBindingStub _stub = new com.example.ws.HelloWebServicePortBindingStub(portAddress, this);
            _stub.setPortName(getHelloWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloWebServicePortEndpointAddress(java.lang.String address) {
        HelloWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.example.ws.HelloWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.example.ws.HelloWebServicePortBindingStub _stub = new com.example.ws.HelloWebServicePortBindingStub(new java.net.URL(HelloWebServicePort_address), this);
                _stub.setPortName(getHelloWebServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HelloWebServicePort".equals(inputPortName)) {
            return getHelloWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.example.com/", "HelloWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.example.com/", "HelloWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloWebServicePort".equals(portName)) {
            setHelloWebServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
