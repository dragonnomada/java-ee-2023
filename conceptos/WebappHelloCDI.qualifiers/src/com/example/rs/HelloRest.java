package com.example.rs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.service.EnterpriseHello;
import com.example.service.HelloService;
import com.example.service.SimpleHello;

@Path("/hello")
@RequestScoped
public class HelloRest {

	@Inject
	@SimpleHello
	HelloService simpleHelloService;
	
	@Inject
	@EnterpriseHello
	HelloService enterpriseHelloService;
	
	@GET
	@Path("/inc")
	public int doIncrement() {
		return simpleHelloService.increment();
	}
	
	@GET
	@Path("/dec")
	public int doDecrement() {
		return simpleHelloService.decrement();
	}
	
	@GET
	@Path("/pro/inc")
	public int doIncrementPro() {
		return enterpriseHelloService.increment();
	}
	
	@GET
	@Path("/pro/dec")
	public int doDecrementPro() {
		return enterpriseHelloService.decrement();
	}
	
}
