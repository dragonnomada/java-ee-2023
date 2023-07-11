package com.example.beans;

import java.util.Date;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.faces.bean.RequestScoped;

@ManagedBean // @ManagedBean(name="myCustomBean")
//@RequestScoped
@SessionScoped
public class HelloBean { // @bean -> helloBean

	Logger logger = Logger.getLogger("HelloBean");
	
	private int count = 0;
	private String title = "Hola JavaBeans";

	public String getTitle() {
		return title;
	}
	
	public String getCurrentDate() {
		count++;
		if (count == 10) {
			// Log -> El usuario ha actualizado la página 10 veces
			logger.warning("El usuario ha actualizado 10 veces");
		}
		title = String.format("Hola JavaBeans (%d)", count);
		return new Date().toString();
	}
	
}
