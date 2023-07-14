package com.example.jms;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSRuntimeException;
import javax.jms.Message;
import javax.jms.Queue;

@ManagedBean
@ApplicationScoped
public class HelloConsumerService {

	Logger logger = Logger.getLogger("HelloProducerService");

	@Resource(lookup = "jms/TestConnectionFactory")
	ConnectionFactory connectionFactory;

	@Resource(lookup = "jms/TestQueue")
	Queue queue;

	public String status() {
		String connectionStatus = "ConnectionFactory: " + connectionFactory == null ? "null"
				: connectionFactory.toString();

		String queueStatus = "Queue: " + queue == null ? "null" : queue.toString();

		logger.info(connectionStatus);
		logger.info(queueStatus);

		return connectionStatus + "\n" + queueStatus;
	}

	public List<String> getMessages() {
		List<String> messages = new ArrayList<String>();

		try (JMSContext jmsContext = connectionFactory.createContext();) {
			Destination destination = (Destination) queue;

			JMSConsumer consumer = jmsContext.createConsumer(destination);

			int count = 0;

			logger.info("Consumer message start");

			for (int i = 0; i < 10; i++) {
				Message message = consumer.receive(1);
				
				if (message == null) {
					break;
				}

				try {
					String messageText = message.getBody(String.class);

					messages.add(messageText);

					logger.info(String.format("Consumer message [%d]: %s", ++count, messageText));
				} catch (JMSException e) {
					logger.warning("Consumer Message error: " + e.getMessage());
					break;
				}
			}
			
			logger.info(String.format("Consumer end of messages: Count=[%d]", count));
		} catch (JMSRuntimeException e) {
			logger.warning("Consumer JMSContext error: " + e.getMessage());
		}

		return messages;
	}

}
