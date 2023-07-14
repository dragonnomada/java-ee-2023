package com.example.rs;

import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.example.ws.HelloWebService;
import com.example.ws.HelloWebServiceProxy;

@Path("/hello")
public class HelloRest {

	// No es correcto -> Envolver en Bean
	HelloWebService helloWebService = new HelloWebServiceProxy();
	
	@GET
	@Path("/report")
	public String report(@QueryParam("min") Double min, @QueryParam("max") Double max) {
		if (min == null) {
			min = 0.0;
		}
		
		if (max == null) {
			max = 0.0;
		}
		
		try {
			return helloWebService.generarReporte(min, max);
		} catch (RemoteException e) {
			return "Error: " + e.getMessage();
		}
	}
	
}
