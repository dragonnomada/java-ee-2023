package com.example.test;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.ejb.HelloEJBServiceStateful;

@Path("/test/hello/stateful")
public class HelloEJBServiceStatefulTestRest {

	@EJB
	HelloEJBServiceStateful helloServiceStateful;

	@GET
	public String helloTest() {
		String result = "";

		for (int i = 0; i < 10; i++) {
			result += helloServiceStateful.getTitle() + "\n";
		}

		return result;
	}

}
