package com.example.ws;

public class HelloWebServiceProxy implements com.example.ws.HelloWebService {
	
	private String _endpoint = null;
	private com.example.ws.HelloWebService helloWebService = null;

	public HelloWebServiceProxy() {
		_initHelloWebServiceProxy();
	}

	public HelloWebServiceProxy(String endpoint) {
		_endpoint = endpoint;
		_initHelloWebServiceProxy();
	}

	private void _initHelloWebServiceProxy() {
		try {
			helloWebService = (new com.example.ws.HelloWSLocator()).getHelloWebServicePort();
			if (helloWebService != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) helloWebService)._setProperty("javax.xml.rpc.service.endpoint.address",
							_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) helloWebService)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (helloWebService != null)
			((javax.xml.rpc.Stub) helloWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.example.ws.HelloWebService getHelloWebService() {
		if (helloWebService == null)
			_initHelloWebServiceProxy();
		return helloWebService;
	}

	public java.lang.String sayHello() throws java.rmi.RemoteException {
		if (helloWebService == null)
			_initHelloWebServiceProxy();
		return helloWebService.sayHello();
	}

	public java.lang.String generarReporte(double min, double max) throws java.rmi.RemoteException {
		if (helloWebService == null)
			_initHelloWebServiceProxy();
		return helloWebService.generarReporte(min, max);
	}

}