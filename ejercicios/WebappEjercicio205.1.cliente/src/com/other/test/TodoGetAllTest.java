package com.other.test;

import java.rmi.RemoteException;

import com.example.ws.Todo;
import com.example.ws.TodoWebService;
import com.example.ws.TodoWebServiceProxy;

public class TodoGetAllTest {

	public static void main(String[] args) throws RemoteException {
		
		TodoWebService todoService = new TodoWebServiceProxy();
		
		Todo[] todos = todoService.getTodos();
		
		for (Todo todo : todos) {
			System.out.printf("[%d - %s] %s %n", todo.getId(), 
					todo.isIsChecked(), todo.getTitle());
		}
		
	}
	
}
