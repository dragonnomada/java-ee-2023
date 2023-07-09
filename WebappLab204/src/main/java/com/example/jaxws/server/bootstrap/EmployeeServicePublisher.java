package com.example.jaxws.server.bootstrap;

import javax.xml.ws.Endpoint;

import com.example.jaxws.server.bottomup.EmployeeServiceImpl;
import com.example.jaxws.server.topdown.EmployeeServiceTopDownImpl;

public class EmployeeServicePublisher {
	 public static void main(String[] args) {
//		 netstat -ano | findstr :8080
//		 taskkill /F /PID XXXX
		 
        Endpoint.publish(
          "http://localhost:8080/employeeservicetopdown", 
           new EmployeeServiceTopDownImpl());

        Endpoint.publish("http://localhost:8080/employeeservice", 
          new EmployeeServiceImpl());
        
        System.out.println("Servidor iniciado");
    }
}
