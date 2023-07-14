package com.example.ws;

public class FrutasWSProxy implements com.example.ws.FrutasWS_PortType {
  private String _endpoint = null;
  private com.example.ws.FrutasWS_PortType frutasWS_PortType = null;
  
  public FrutasWSProxy() {
    _initFrutasWSProxy();
  }
  
  public FrutasWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initFrutasWSProxy();
  }
  
  private void _initFrutasWSProxy() {
    try {
      frutasWS_PortType = (new com.example.ws.FrutasWS_ServiceLocator()).getFrutasWSPort();
      if (frutasWS_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)frutasWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)frutasWS_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (frutasWS_PortType != null)
      ((javax.xml.rpc.Stub)frutasWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.example.ws.FrutasWS_PortType getFrutasWS_PortType() {
    if (frutasWS_PortType == null)
      _initFrutasWSProxy();
    return frutasWS_PortType;
  }
  
  public com.example.ws.Fruta deleteFruta(long id) throws java.rmi.RemoteException{
    if (frutasWS_PortType == null)
      _initFrutasWSProxy();
    return frutasWS_PortType.deleteFruta(id);
  }
  
  public com.example.ws.Fruta updateFruta(long id, java.lang.String nombre, double precio, double peso, int existencias) throws java.rmi.RemoteException{
    if (frutasWS_PortType == null)
      _initFrutasWSProxy();
    return frutasWS_PortType.updateFruta(id, nombre, precio, peso, existencias);
  }
  
  public com.example.ws.Fruta getFrutaById(long id) throws java.rmi.RemoteException{
    if (frutasWS_PortType == null)
      _initFrutasWSProxy();
    return frutasWS_PortType.getFrutaById(id);
  }
  
  public com.example.ws.Fruta[] getAllFrutas() throws java.rmi.RemoteException{
    if (frutasWS_PortType == null)
      _initFrutasWSProxy();
    return frutasWS_PortType.getAllFrutas();
  }
  
  public com.example.ws.Fruta addFruta(java.lang.String nombre, double precio) throws java.rmi.RemoteException{
    if (frutasWS_PortType == null)
      _initFrutasWSProxy();
    return frutasWS_PortType.addFruta(nombre, precio);
  }
  
  
}