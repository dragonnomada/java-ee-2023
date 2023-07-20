package com.example.rs;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.async.AsyncDemoService;
import com.example.async.DemoObserver;
import com.example.async.VisitHistorial;

@Path("/visit")
@Stateless
public class VisitsRest {

	@Inject
	AsyncDemoService demoService;

	@Inject
	DemoObserver demoObserver; // Es un observador compartido entre todos los componentes

	Future<VisitHistorial> historialFuture;

	@GET
	public String visits() {
		if (historialFuture == null) {
			return "Inicia el registro y espera 1 minuto";
		}

		if (historialFuture.isDone()) {
			try {
				VisitHistorial historial = historialFuture.get();
				return historial.report();
			} catch (Exception e) {
				return e.getMessage();
			}

		} else {
			return "El historial aún no está listo (espera 1 minuto aproximadamente)";
		}
	}

	@GET
	@Path("/report")
	public String getReport() {
		if (historialFuture == null) {
			return "Inicia el registro y espera 1 minuto";
		}
		
		try {
			VisitHistorial historial = historialFuture.get();
			return historial.report();
		} catch (Exception e) {
			return e.getMessage();		
		}
	}

	@GET
	@Path("/demo")
	public String doVisit() {
		demoObserver.increment();
		return "Visits:" + demoObserver.getCount();
	}

	@GET
	@Path("/start")
	public String startRecord() {
		historialFuture = demoService.startRecordHistorial();
		return "OK - " + new Date() + " " + (historialFuture == null ? "FAIL" : "SUCCESS");
	}

}
