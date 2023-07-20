package com.example.ejb;

import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class MyAsyncBean {

	Logger logger = Logger.getLogger("MyAsyncBean");
	
	String message = "Waiting...";
	
	@Asynchronous
	public Future<String> sayHello() throws InterruptedException {
		logger.info("Iniciando tarea sayHello()");
		
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				logger.info("Ejecutando tarea sayHello()...");
				message = "Hello world";
				try {
					Thread.sleep(30_000);
				} catch (Exception e) {
					//
				}
				logger.info("Finalizando tarea sayHello()...");
			}
			
		});
		
		myThread.start();
		
		myThread.join();
		
		logger.info("Tarea sayHello() completada");
		
		return new AsyncResult<String>(message);
	}
	
}
