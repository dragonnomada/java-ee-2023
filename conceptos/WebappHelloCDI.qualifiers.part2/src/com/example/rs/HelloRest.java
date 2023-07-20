package com.example.rs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.service.HelloService;
import com.example.service.ProHello;
//import com.example.service.SimpleHello;

@Path("/hello")
@RequestScoped
public class HelloRest {

	@Inject
//	@SimpleHello
	@ProHello
	HelloService helloService;
	
	@GET
	public String hello() {
		return helloService.sayHello() +
				": " + helloService.getCount();
	}
	
}
