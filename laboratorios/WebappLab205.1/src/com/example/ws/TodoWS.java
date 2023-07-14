package com.example.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.example.model.Todo;
import com.example.service.TodoService;

@WebService(serviceName="TodoWS")
public class TodoWS {

	@Inject
	TodoService todoService;
	
	@WebMethod
	public Todo addTodo(@WebParam(name="title") String title, 
			@WebParam(name="checked") boolean checked) {
		Todo todo = todoService.addTodo(title);
		return todoService.checkTodo(todo.getId());
	}
	
	@WebMethod
	public Todo[] getTodos() {
		return todoService.getTodos();
	}
	
}
