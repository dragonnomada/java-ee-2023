package com.example.rs;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.jms.HelloConsumerService;

@Path("/jms/consumer/test")
@RequestScoped
public class TestHelloConsumerServiceRest {

	@Inject
	HelloConsumerService helloConsumerService;
	
	@GET
	public String status() {
		return helloConsumerService.status();
	}
	
	@GET
	@Path("/messages")
	@Produces("text/html")
	public String getMessages() {
		List<String> messages = helloConsumerService.getMessages();
		
		String html = "<ul>";
		
		for (String messageText : messages) {
			html += "<li>" + messageText + "</li>";
		}
		
		if (messages.size() == 0) {
			html += "<small>No hay mensajes</small>";
		}
		
		html += "<ul>";
		
		return html;
	}
	
}
