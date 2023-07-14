package com.example.ws;

public class TodoWSProxy implements com.example.ws.TodoWS_PortType {
  private String _endpoint = null;
  private com.example.ws.TodoWS_PortType todoWS_PortType = null;
  
  public TodoWSProxy() {
    _initTodoWSProxy();
  }
  
  public TodoWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initTodoWSProxy();
  }
  
  private void _initTodoWSProxy() {
    try {
      todoWS_PortType = (new com.example.ws.TodoWS_ServiceLocator()).getTodoWSPort();
      if (todoWS_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)todoWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)todoWS_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (todoWS_PortType != null)
      ((javax.xml.rpc.Stub)todoWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.example.ws.TodoWS_PortType getTodoWS_PortType() {
    if (todoWS_PortType == null)
      _initTodoWSProxy();
    return todoWS_PortType;
  }
  
  public com.example.ws.Todo[] getTodos() throws java.rmi.RemoteException{
    if (todoWS_PortType == null)
      _initTodoWSProxy();
    return todoWS_PortType.getTodos();
  }
  
  public com.example.ws.Todo addTodo(java.lang.String title, boolean checked) throws java.rmi.RemoteException{
    if (todoWS_PortType == null)
      _initTodoWSProxy();
    return todoWS_PortType.addTodo(title, checked);
  }
  
  
}