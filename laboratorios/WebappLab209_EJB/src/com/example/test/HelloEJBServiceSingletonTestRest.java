package com.example.test;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.ejb.HelloEJBServiceSingleton;

@Path("/test/hello/singleton")
public class HelloEJBServiceSingletonTestRest {
	
	@EJB
	HelloEJBServiceSingleton helloServiceSingleton;
	
	@GET
	public String helloTest() {
		String result = "";
		
		for (int i = 0; i < 10; i++) {
			result += helloServiceSingleton.getTitle() + "\n";
		}
		
		return result;
	}
	
}
