package com.example.rs;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.example.entity.Demo;
import com.example.jpa.DemoService;

@Path("/demo")
@Consumes("application/xml")
@Produces("application/xml")
@RequestScoped
public class DemoRest {

	@Inject
	DemoService demoService;
	
	@GET
	public List<Demo> getDemos() {
		return demoService.getDemos();
	}
	
	@GET
	@Path("/insecure/add")
	public Demo addDemo(@QueryParam("title") String title) {
		return demoService.addDemo(title);
	}
	
}
