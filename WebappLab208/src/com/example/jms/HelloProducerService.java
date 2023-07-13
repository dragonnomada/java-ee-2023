package com.example.jms;

import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;

@ManagedBean
@ApplicationScoped
public class HelloProducerService {

	Logger logger = Logger.getLogger("HelloProducerService");
	
	@Resource(lookup="jms/TestConnectionFactory")
	ConnectionFactory connectionFactory;
	
	@Resource(lookup="jms/TestQueue")
	Queue queue;
	
	public String status() {
		String connectionStatus = "ConnectionFactory: " + 
				connectionFactory == null ? "null" : connectionFactory.toString();
		
		String queueStatus = "Queue: " +
				queue == null ? "null" : queue.toString();
		
		logger.info(connectionStatus);
		logger.info(queueStatus);
		
		return connectionStatus + "\n" + queueStatus;
	}
	
	public String sendMessage(String message) {
		try ( JMSContext jmsContext = connectionFactory.createContext(); ) {
			JMSProducer producer = jmsContext.createProducer();
			
			Destination destination = (Destination) queue;
			
			producer.send(destination, message);
			
			logger.info("Producer message sended: " + message);
			
			return String.format("ok -- %s", message);
		} catch (JMSRuntimeException e) {
			logger.warning("Producer JMSContext error: " + e.getMessage());
			return String.format("fail -- %s", message);
		}
	}
	
}
