package com.example.rs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.jms.DemoTopicProducerService;

@Path("/ping")
@RequestScoped
public class DemoTopicProducerRest {

	@Inject
	DemoTopicProducerService demoTopicProducerService;
	
	@GET
	public String ping() {
		return demoTopicProducerService.ping();
	}
	
}
