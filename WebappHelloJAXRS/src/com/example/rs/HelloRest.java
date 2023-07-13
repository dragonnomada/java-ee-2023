package com.example.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

// JAX-RS

@Path("/hello") // /api/hello
public class HelloRest {

	@GET // GET /api/hello?name=Ana
	public String hello(@QueryParam("name") String name) {
		return String.format("Hello, %s (JAX-RS)", name); // Hello, Ana
	}
	
}
