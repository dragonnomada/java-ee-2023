package com.example.ejb;

import java.util.logging.Logger;

import javax.ejb.Singleton;

@Singleton
public class AsyncCounterService {

	private Logger logger = Logger.getLogger("AsyncCounterService");

	private Thread counterThread;

	private int count = 0;
	
	private boolean started = false;

	public int getCount() {
		return count;
	}
	
	public void increment() {
		++count;
	}
	
	public void decrement() {
		--count;
	}

	public void reset() {
		logger.info("Reiniciando el contador");
		count = 0;
	}
	
	public void restart() {
		stop();
		reset();
		start();
	}

	public void start() {

		logger.info("Iniciando el hilo");

		stop();

		logger.info("Generar un nuevo hilo");
		
		counterThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (started) { // CUIDADO AL USAR while (true)
					if (!started) {
						break;
					}
					
					logger.info("Incrementando el contador");
					increment();
					try {
						logger.info("Esperando 1 segundo...");
						Thread.sleep(1_000);
					} catch (Exception e) {

					}
				}
			}
		});

		started = true;
		
		// Iniciando el hilo
		counterThread.start();

	}

	public void stop() {
		logger.info("Deteniendo el hilo...");

		if (counterThread != null) {
			logger.info("El hilo ya existe");
			// Detenemos el hilo actual
			logger.info("Eliminando el hilo (actual)");
			//counterThread.interrupt();
			started = false;
			try {
				counterThread.join();
			} catch (InterruptedException e) {
				//
			}
			counterThread = null;
			logger.info("El hilo ya se ha eliminado");
		} else {
			logger.info("El hilo no existe");
		}
	}

}
