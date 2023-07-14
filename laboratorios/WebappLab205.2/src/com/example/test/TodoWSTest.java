package com.example.test;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import com.example.ws.Todo;
import com.example.ws.TodoWSProxy;

public class TodoWSTest {

	public static void main(String[] args) throws RemoteException {
		TodoWSProxy proxy = new TodoWSProxy();
		
		//proxy.addTodo("Hola Todo desde Proxy", true);
		
		for (Todo todo : proxy.getTodos()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss Z");
			String result = dateFormat.format(todo.getCreatedAt().getTime());
			System.out.printf("[%d] %s (%s) <%s> %n", todo.getId(),
					todo.getTitle(), todo.getIsChecked(),
					result);
		}
	}

}
