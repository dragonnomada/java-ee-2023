package com.example.beans;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean // Genera un bean administrado (helloBean)
@RequestScoped // El bean sólo vivirá mientras la petición exista 
			   // (mientras el usuario interactua con la página .xhtml)
// @SessionScoped // El bean vivirá durante toda la sesión
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
