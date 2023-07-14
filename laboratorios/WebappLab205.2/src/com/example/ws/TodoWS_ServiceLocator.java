/**
 * TodoWS_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.ws;

public class TodoWS_ServiceLocator extends org.apache.axis.client.Service implements com.example.ws.TodoWS_Service {

    public TodoWS_ServiceLocator() {
    }


    public TodoWS_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TodoWS_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TodoWSPort
    private java.lang.String TodoWSPort_address = "http://localhost:8080/WebappLab205.1/TodoWS";

    public java.lang.String getTodoWSPortAddress() {
        return TodoWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TodoWSPortWSDDServiceName = "TodoWSPort";

    public java.lang.String getTodoWSPortWSDDServiceName() {
        return TodoWSPortWSDDServiceName;
    }

    public void setTodoWSPortWSDDServiceName(java.lang.String name) {
        TodoWSPortWSDDServiceName = name;
    }

    public com.example.ws.TodoWS_PortType getTodoWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TodoWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTodoWSPort(endpoint);
    }

    public com.example.ws.TodoWS_PortType getTodoWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.example.ws.TodoWSPortBindingStub _stub = new com.example.ws.TodoWSPortBindingStub(portAddress, this);
            _stub.setPortName(getTodoWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTodoWSPortEndpointAddress(java.lang.String address) {
        TodoWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.example.ws.TodoWS_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.example.ws.TodoWSPortBindingStub _stub = new com.example.ws.TodoWSPortBindingStub(new java.net.URL(TodoWSPort_address), this);
                _stub.setPortName(getTodoWSPortWSDDServiceName());
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
        if ("TodoWSPort".equals(inputPortName)) {
            return getTodoWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.example.com/", "TodoWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.example.com/", "TodoWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TodoWSPort".equals(portName)) {
            setTodoWSPortEndpointAddress(address);
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
