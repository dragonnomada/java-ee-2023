package com.example.test;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.ejb.HelloEJBServiceStateless;

@Path("/test/hello/stateless")
public class HelloEJBServiceStatelessTestRest {

	@EJB
	HelloEJBServiceStateless helloServiceStateless;
	
	@GET
	public String helloTest() {
		String result = "";
		
		for (int i = 0; i < 10; i++) {
			result += helloServiceStateless.getTitle() + "\n";
		}
		
		return result;
	}
	
}
