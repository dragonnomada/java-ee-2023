package com.example.rs;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/jee_user")
@RequestScoped
public class JEEUserRest {

	@GET
	public String test1() {
		return "Test 1 - OK - " + new Date();
	}
	
	@GET
	@Path("/2")
	public String test2() {
		return "Test 2 - OK - " + new Date();
	}
	
}
