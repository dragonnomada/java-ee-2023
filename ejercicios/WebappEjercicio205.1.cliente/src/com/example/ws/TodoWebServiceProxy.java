package com.example.ws;

public class TodoWebServiceProxy implements com.example.ws.TodoWebService {
  private String _endpoint = null;
  private com.example.ws.TodoWebService todoWebService = null;
  
  public TodoWebServiceProxy() {
    _initTodoWebServiceProxy();
  }
  
  public TodoWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initTodoWebServiceProxy();
  }
  
  private void _initTodoWebServiceProxy() {
    try {
      todoWebService = (new com.example.ws.TodoWSLocator()).getTodoWebServicePort();
      if (todoWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)todoWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)todoWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (todoWebService != null)
      ((javax.xml.rpc.Stub)todoWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.example.ws.TodoWebService getTodoWebService() {
    if (todoWebService == null)
      _initTodoWebServiceProxy();
    return todoWebService;
  }
  
  public com.example.ws.Todo[] getTodos() throws java.rmi.RemoteException{
    if (todoWebService == null)
      _initTodoWebServiceProxy();
    return todoWebService.getTodos();
  }
  
  public com.example.ws.Todo addTodo(java.lang.String title) throws java.rmi.RemoteException{
    if (todoWebService == null)
      _initTodoWebServiceProxy();
    return todoWebService.addTodo(title);
  }
  
  public com.example.ws.Todo getTodo(long id) throws java.rmi.RemoteException{
    if (todoWebService == null)
      _initTodoWebServiceProxy();
    return todoWebService.getTodo(id);
  }
  
  
}