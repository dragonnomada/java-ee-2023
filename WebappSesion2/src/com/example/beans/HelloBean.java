package com.example.beans;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean // Genera un bean administrado (helloBean)
@RequestScoped // El bean s�lo vivir� mientras la petici�n exista 
			   // (mientras el usuario interactua con la p�gina .xhtml)
// @SessionScoped // El bean vivir� durante toda la sesi�n
public class HelloBean {

	private String title = "Hola JavaBean (HelloBean)";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String currentDate() {
		return String.format("Fecha actual: %s", new Date());
	}
	
}
