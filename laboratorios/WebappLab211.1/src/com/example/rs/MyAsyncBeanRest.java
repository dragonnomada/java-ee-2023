package com.example.rs;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.ejb.MyAsyncBean;

@Path("/myAsyncBean")
@Stateless
public class MyAsyncBeanRest {

	@Inject
	MyAsyncBean myAsyncBean;

	Future<String> result;
	
	Date start = null;
	boolean executing = false;
	
	@GET
	public String info() {
		if (result == null) {
			return "La tarea no está en ejecución";
		} else {
			if (result.isDone()) {
				executing = false;
				start = null;
				try {
					return result.get();
				} catch (InterruptedException e) {
					return e.getMessage();
				} catch (ExecutionException e) {
					return e.getMessage();
				}
			} else {
				String result = "La tarea se sigue ejecutando...";
				result += " Tiempo de ejecución: ";
				double elapsed = (new Date().getTime() - start.getTime()) / 1_000.0;
				result += String.format("%.1f s", elapsed);
				return result;
			}
		}
	}

	@GET
	@Path("/start")
	public String start() {
		try {
			start = new Date();
			executing = true;
			result = myAsyncBean.sayHello();
			return "Ok - " + new Date();
		} catch (InterruptedException e) {
			return "Fail - " + e.getMessage();
		}
	}

}
