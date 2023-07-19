package com.example.jms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;

@Singleton
public class DemoTopicConsumerService {

	Logger logger = Logger.getLogger("DemoTopicConsumerService");
	
	@Resource(lookup = "jms/DemoTopicConnectionFactory")
	ConnectionFactory connectionFactory;
	
	@Resource(lookup = "jms/DemoTopic")
	Topic topic;
	
	List<String> messages = new ArrayList<String>();
	
	MessageListener listener;
	
	JMSContext context;
	
	JMSConsumer consumer;
	
	public DemoTopicConsumerService() {
		
		// Implementación hot-pot de un MessageListener
		listener = new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				String messageText;
				try {
					messageText = message.getBody(String.class);
					messages.add(messageText);
					
					if (messages.size() > 10) {
						messages.remove(0); // FIFO (first-in -> first-out)
					}
				} catch (JMSException e) {
					logger.warning("DemoTopicConsumerService()/MessageListener/onMessage error: " + e.getMessage());
				}
				
			}
			
		};
		
	}
	
	public void doSubscribe() {
		System.out.println(connectionFactory);
		System.out.println(topic);
		
		try ( JMSContext context = connectionFactory.createContext(); ) {
			
			this.context = context;
			
			context.stop();
			
//			Destination destination = (Destination) topic;
//			
//			this.consumer = context.createConsumer(destination);
			
			this.consumer = context.createDurableConsumer(topic, "DemoTopicConsumer");
			
			// TODO: Migrar a EJB Asíncronos
			
			this.consumer.setMessageListener(listener);
			
			context.start();
			
		} catch (Exception e) {
			logger.warning("DemoTopicConsumerService() error: " + e.getMessage());
		}
	}
	
	public void doUnsubscribe() {
		this.consumer.close();
		this.context.unsubscribe("DemoTopicConsumer");
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
}
