package com.example.rs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.service.HelloService;

@Path("/hello")
@RequestScoped
public class HelloRest {

	@Inject
	HelloService helloService;
	
	@GET
    @Produces("text/html")
    public String hello() {
        String date = helloService.currentDate();
        return "<br><br><br><center><h1>" + date + "<h1></center>";
    }
	
}
