package com.example.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.example.beans.HelloBean;

@WebService(serviceName="HelloService")
public class HelloService {

	@EJB
	HelloBean helloBean;
	
	@WebMethod
	public String hello(@WebParam(name="name") String name) {
		return helloBean.sayHello(name);
	}
	
}
