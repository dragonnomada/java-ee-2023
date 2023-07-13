package com.example.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.example.model.Greeting;

@WebService(serviceName="HelloWS") // /HelloWS/?wsdl
public class HelloWebService {

    @WebMethod // <ws:sayHello> <firstName>Ana</firstName> </ws:sayHello>
    @WebResult(name="greeting") // <greeting> <title> ... </title> </greeting>
    public Greeting sayHello(@WebParam(name="firstName") String name) {
        return new Greeting(name); // <title> Hello, Ana </soap>
    }

}
