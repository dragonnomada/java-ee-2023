package com.example.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName="HelloWS")
public class HelloWebService {

    @WebMethod
    @WebResult(name="message")
    public String sayHello() {
        return "Hello world :D";
    }

    @WebMethod
    @WebResult(name="report")
    public String generarReporte(@WebParam(name="min") double min, 
                                    @WebParam(name="max") double max) {
        return String.format("Hello, min=%.2f, max=%.2f, avg=%.2f", min, max, (min + max) / 2);
    }

    // ... Otros métodos

}