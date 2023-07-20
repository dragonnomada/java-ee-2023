package com.example.test;

import com.example.jms.DemoTopicConsumerService;

public class DemoTopicConsumerTest {

	public static void main(String[] args) {
		
		DemoTopicConsumerService topicService = new DemoTopicConsumerService();
		
		topicService.doSubscribe();
		
		while (true) {
			
			System.out.println("Mensajes:");
			System.out.println("----------------------------------");
			
			int i = 0;
			
			for (String message : topicService.getMessages()) {
				System.out.printf("[%d] %s %n", ++i, message);
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("Falló el sleep");
			}
			
		}
		
	}
	
}
