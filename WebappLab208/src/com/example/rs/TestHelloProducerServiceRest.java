package com.example.rs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.example.jms.HelloProducerService;

@Path("/jms/producer/test")
@RequestScoped
public class TestHelloProducerServiceRest {

	@Inject
	HelloProducerService helloProducerService;
	
	@GET
	public String status() {
		return helloProducerService.status();
	}
	
	@GET
	@Path("/send") 
	public String sendMessage(@QueryParam("message") String message) {
		return helloProducerService.sendMessage(message);
	}
	
}
