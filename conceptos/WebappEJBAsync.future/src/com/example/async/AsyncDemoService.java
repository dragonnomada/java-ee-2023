package com.example.async;

import java.util.Date;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AsyncDemoService {

	@Inject
	DemoObserver observer;
	
	@Asynchronous
	public Future<VisitHistorial> startRecordHistorial() {

		VisitHistorial visitHistorial = new VisitHistorial();
		
		for (int i = 0; i < 10; i++) {
			Date now = new Date();
			visitHistorial.addVisit(now, observer.getCount());
			observer.reset();
			try {
				Thread.sleep(1_000);
			} catch (InterruptedException e) {
				//
			}
		}
		
		return new AsyncResult<VisitHistorial>(visitHistorial);

	}

}
