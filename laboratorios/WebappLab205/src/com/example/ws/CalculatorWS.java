package com.example.ws;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "CalculatorWS")
public class CalculatorWS {

	@WebMethod
	public int add(@WebParam(name = "a") int i, @WebParam(name = "b") int j) {
		return i + j;
	}
	
}
