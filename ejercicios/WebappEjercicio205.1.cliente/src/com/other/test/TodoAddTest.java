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
		
		Todo todo = todoService.addTodo("Hola estoy probando tu web service desde mi c�digo");
		
		System.out.printf("[%d - %s] %s (%s / %s) %n", todo.getId(), todo.isIsChecked(), 
				todo.getTitle(), todo.getCreatedAt(), todo.getUpdatedAt());
		
	}
	
}

/*
 * La Invocaci�n de un M�todo Remoto (RMI - Remote Method Invoke)
 * nos permite ejecutar m�todos de una aplicaci�n de Java de forma remota,
 * es decir, al ejecutar un m�todo, existir� la clase espejo en el servidor,
 * la cu�l contenga el mismo m�todo y lo ejecute.
 * 
 * Los par�metros y resultados ser�n serializados y transportados por el socket
 * de punto a punto (cliente <-> servidor)
 * 
 */
