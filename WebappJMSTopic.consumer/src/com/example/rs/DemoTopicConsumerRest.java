package com.example.rs;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.jms.DemoTopicConsumerService;

@Path("/messages")
@RequestScoped
public class DemoTopicConsumerRest {

	@Inject
	DemoTopicConsumerService demoTopicConsumerService;
	
	@GET
	@Path("/subscribe")
	public String subscribe() {
		demoTopicConsumerService.doSubscribe();
		return "OK";
	}
	
	@GET
	@Path("/unsubscribe")
	public String unsubscribe() {
		demoTopicConsumerService.doUnsubscribe();
		return "OK";
	}
	
	@GET
	@Produces("text/html")
	public String getMessages() {
		List<String> messages = demoTopicConsumerService.getMessages();
		
		String html = "<table>";
		
		html += "<thead>";
		html += "<tr>";
		html += "<th>ID</th>";
		html += "<th>MESSAGE</th>";
		html += "</tr>";
		html += "</thead>";

		html += "<tbody>";
		
		int i = 0;
		
		for (String message : messages) {
			html += "<tr>";
			html += "<td>" + (++i) + "</td>";
			html += "<td>" + message + "</td>";
			html += "</tr>";
		}
		
		html += "</tbody>";
		html += "</table>";
		
		return html;
	}
	
}
