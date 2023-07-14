package com.example.test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.ejb.HelloEJBServiceStateless;

@Path("/test/hello")
@RequestScoped
public class HelloEJBServiceTestRest {

	@Inject
	HelloEJBServiceStateless helloService;
	
	@GET
	public String helloTest() {
		String result = "";
		
		for (int i = 0; i < 10; i++) {
			result += helloService.getTitle() + "\n";
		}
		
		return result;
	}
	
}
