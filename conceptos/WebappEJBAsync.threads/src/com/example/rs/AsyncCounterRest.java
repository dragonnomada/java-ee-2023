package com.example.rs;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.ejb.AsyncCounterService;

@Path("/counter")
@RequestScoped
public class AsyncCounterRest {

	@Inject
	AsyncCounterService counterService;
	
	@GET
	public String getCount() {
		return "Count: " + counterService.getCount();
	}
	
	@GET
	@Path("/start")
	public String start() {
		counterService.start();
		return "OK - " + new Date();
	}
	
	@GET
	@Path("/stop")
	public String stop() {
		counterService.stop();
		return "OK - " + new Date();
	}
	
	@GET
	@Path("/restart")
	public String restart() {
		counterService.restart();
		return "OK - " + new Date();
	}
	
	
	@GET
	@Path("/inc")
	public String inc() {
		counterService.increment();
		return "OK - " + new Date();
	}
	
	@GET
	@Path("/dec")
	public String dec() {
		counterService.decrement();
		return "OK - " + new Date();
	}
	
	@GET
	@Path("/reset")
	public String reset() {
		counterService.reset();
		return "OK - " + new Date();
	}
	
}
