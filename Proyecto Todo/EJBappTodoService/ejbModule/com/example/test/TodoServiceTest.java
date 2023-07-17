package com.example.test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import com.example.model.Todo;
import com.example.service.TodoService;

public class TodoServiceTest {

	public static void main(String[] args) throws NamingException {
		
		System.out.println("Probando TodoServiceTest");
		
		// Creamos un EJB Container "virtual"
		EJBContainer ejbContainer = EJBContainer.createEJBContainer();
		
		// Accedemos a su contexto para buscar la clase
		Context context = ejbContainer.getContext();
		
		// Usamos el JNDI para buscar el servicio
		TodoService todoService = (TodoService) context.lookup("java:global/TodoService");
		
		todoService.addTodo("Probar el servicio");
		
		for (Todo todo : todoService.getTodos()) {
			System.out.println(todo);
		}
		
	}
	
}
