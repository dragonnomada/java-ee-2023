package com.example.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.example.model.Todo;
import com.example.model.TodoList;

// JAX-WS

@WebService(serviceName="TodoWS") // -> WSDL (SOAP)
public class TodoWebService {
	
	// Servicio de Todos (o retener los nuestros)
	List<Todo> todos = new ArrayList<Todo>();
	long nextId = 1;
	
	@WebMethod
	@WebResult(name = "todo")
	public Todo addTodo(@WebParam(name="title") String title) {
		Todo todo = new Todo();
		
		todo.setId(nextId++);
		todo.setTitle(title == null ? "Sin título" : title);
		todo.setCreated(new Date());
		todo.setUpdated(null);
		todo.setChecked(false);
		
		todos.add(todo);
		
		return todo;
	}
	
	@WebMethod
	@WebResult(name = "todos")
	public TodoList getTodos() {
		return TodoList.build(todos);
	}
	
	@WebMethod
	@WebResult(name = "todo")
	public Todo getTodo(@WebParam(name="id") long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}

/*
 * 
 * Los Servicios Web (JAX-WS) se basan en especificaciones
 * de métodos web que pueden ser consumidos a través SOAP en formato XML.
 * 
 * Estos servicios se consideran auto-explorables por su capacidad
 * de brindar toda la información (WSDL) que describe qué métodos web
 * están disponibles y qué parámetros requieren para funcionar.
 * 
 * Los servicios pueden ser especificados de dos formas:
 * 
 * 1. WSDL - Es un lenguaje que describe el servicio en formato XML
 * 2. POJO - Indica las anotaciones @WebService, @WebMethod, @WebResult, etc. 
 * 			 Para hacer que una clase se convierta en un servicio.
 * 
 */