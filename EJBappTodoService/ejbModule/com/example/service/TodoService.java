package com.example.service;

import java.util.Date;
import java.util.List;

import com.example.model.Todo;

public interface TodoService {

	Todo addTodo(String title);
	
	Todo getTodo(long id);
	
	List<Todo> getTodos();
	
	List<Todo> getTodos(int limit);
	
	List<Todo> getTodos(boolean isChecked);
	
	List<Todo> getTodos(Date start, Date end);
	
	Todo updateTodoTitle(long id, String title);

	Todo checkTodo(long id);

	Todo uncheckTodo(long id);
	
	Todo deleteTodo(long id);
	
}
