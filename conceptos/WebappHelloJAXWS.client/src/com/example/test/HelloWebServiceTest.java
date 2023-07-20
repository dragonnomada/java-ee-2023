package com.example.test;

import java.rmi.RemoteException;

import javax.xml.bind.annotation.XmlT;

import com.example.ws.Greeting;
import com.example.ws.HelloWebService;
import com.example.ws.HelloWebServiceProxy;

// Creamos una aplicación de escritorio
public class HelloWebServiceTest {

	// Creamos el punto de entrada principal de esta prueba
	public static void main(String[] args) {
		
		HelloWebService helloWebService = new HelloWebServiceProxy();
		
		try {
			Greeting greeting = helloWebService.sayHello("Pepe el Toro");
			
			System.out.println(greeting.getTitle());
		} catch (RemoteException e) {
			System.out.println("Error al consumir el método web: " + e.getMessage());
		}
		
	}
	
}
