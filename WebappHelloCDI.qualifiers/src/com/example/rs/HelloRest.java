package com.example.rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.service.HelloService;

@Path("/hello")
public class HelloRest {

	@Inject
	HelloService helloService; // ERROR: Conflicto entre implementaciones no calificadas
	
	@GET
	@Path("/inc")
	public int doIncrement() {
		return helloService.increment();
	}
	
	@GET
	@Path("/dec")
	public int doDecrement() {
		return helloService.decrement();
	}
	
}
