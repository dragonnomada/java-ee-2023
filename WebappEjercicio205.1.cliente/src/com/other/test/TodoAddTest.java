package com.other.test;

import java.rmi.RemoteException;
import java.util.Calendar;

import com.example.ws.Todo;
import com.example.ws.TodoWebService;
import com.example.ws.TodoWebServiceProxy;

// RMI

public class TodoAddTest {

	public static void main(String[] args) throws RemoteException {
		
		TodoWebService todoService = new TodoWebServiceProxy();
		
		Todo todo = todoService.addTodo("Hola estoy probando tu web service desde mi código");
		
		System.out.printf("[%d - %s] %s (%s / %s) %n", todo.getId(), todo.isIsChecked(), 
				todo.getTitle(), todo.getCreatedAt(), todo.getUpdatedAt());
		
	}
	
}

/*
 * La Invocación de un Método Remoto (RMI - Remote Method Invoke)
 * nos permite ejecutar métodos de una aplicación de Java de forma remota,
 * es decir, al ejecutar un método, existirá la clase espejo en el servidor,
 * la cuál contenga el mismo método y lo ejecute.
 * 
 * Los parámetros y resultados serán serializados y transportados por el socket
 * de punto a punto (cliente <-> servidor)
 * 
 */
