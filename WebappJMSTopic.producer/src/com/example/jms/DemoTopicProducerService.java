package com.example.jms;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;

@Stateless
public class DemoTopicProducerService {

	@Resource(lookup = "jms/DemoTopicConnectionFactory")
	ConnectionFactory connectionFactory;
	
	@Resource(lookup = "jms/DemoTopic")
	Topic topic;
	
	public String ping() {
		try ( JMSContext context = connectionFactory.createContext(); ) {
			
			JMSProducer producer = context.createProducer();
			
			Destination destination = (Destination) topic;
			
			producer.send(destination, "Ping -> DemoTopic");
			
			return "Ok - " + new Date().toString();
			
		} catch (Exception e) {
			return "Fail - " + e.getMessage();
		}
	}
	
}
