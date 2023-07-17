package com.example.rs;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.example.model.Todo;
import com.example.service.LocalTodo;
import com.example.service.TodoService;

@WebService(serviceName = "TodoWS")
public class TodoWebService {

	@Inject
	@LocalTodo
	TodoService todoService;

	@WebMethod
	public Todo addTodo(@WebParam(name = "title") String title) {
		return todoService.addTodo(title);
	}

	@WebMethod
	public List<Todo> getTodos() {
		return todoService.getTodos();
	}

	@WebMethod
	public List<Todo> getTodosWithLimit(@WebParam(name = "limit") int limit) {
		return todoService.getTodos(limit);
	}

	@WebMethod
	public List<Todo> getTodosWhenChecked(@WebParam(name = "isChecked") boolean isChecked) {
		return todoService.getTodos(isChecked);
	}
	
	@WebMethod
	public List<Todo> getTodosChecked() {
		return todoService.getTodos(true);
	}
	
	@WebMethod
	public List<Todo> getTodosUnchecked() {
		return todoService.getTodos(false);
	}
	
	@WebMethod
	public Todo updateTodo(@WebParam(name = "todo") Todo todo) {
		Todo todoResult = null;
		
		if (todo.getTitle() != null) {
			todoResult = todoService.updateTodoTitle(todo.getId(), todo.getTitle());
		}
		
		if (todo.getChecked() == true) {
			todoResult = todoService.checkTodo(todo.getId());
		} else if (todo.getChecked() == false) {
			todoResult = todoService.uncheckTodo(todo.getId());
		}
		
		return todoResult;
	}
	
	@WebMethod
	public Todo updateTodoTitle(@WebParam(name = "id") long id, @WebParam(name = "title") String title) {
		return todoService.updateTodoTitle(id, title);
	}
	
	@WebMethod
	public Todo checkTodo(@WebParam(name = "id") long id) {
		return todoService.checkTodo(id);
	}
	
	@WebMethod
	public Todo uncheckTodo(@WebParam(name = "id") long id) {
		return todoService.uncheckTodo(id);
	}
	
	// M�s implementaciones

}
