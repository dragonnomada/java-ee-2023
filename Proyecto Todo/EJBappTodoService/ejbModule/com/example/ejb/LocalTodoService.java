package com.example.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.example.model.Todo;
import com.example.service.LocalTodo;
import com.example.service.TodoService;

@LocalTodo
@Stateless // Bean (EJB) - Vida larga y sin estado externo
public class LocalTodoService implements TodoService {

	Map<Long, Todo> todos = new HashMap<Long, Todo>();
	
	long nextId;

	@Override
	public Todo addTodo(String title) {
		if (title == null) {
			return null;
		}
		
		if (title.trim().equals("")) {
			return null;
		}
		
		Todo todo = new Todo();
		todo.setId(++nextId);
		todo.setTitle(title.trim());
		todo.setChecked(false);
		todo.setCreated(new Date());
		todo.setUpdated(null);
		
		todos.put(todo.getId(), todo);
		
		return todo;
	}

	@Override
	public Todo getTodo(long id) {
		return todos.get(id);
	}

	@Override
	public List<Todo> getTodos() {
		List<Todo> todosCollected = new ArrayList<Todo>();
		
		for (Todo todo : todos.values()) {
			todosCollected.add(todo);
		}
		
		return todosCollected;
	}

	@Override
	public List<Todo> getTodos(int limit) {
		List<Todo> todosCollected = new ArrayList<Todo>();
		
		int i = 0;
		
		for (Todo todo : todos.values()) {
			todosCollected.add(todo);
			if (++i >= limit) {
				return todosCollected;
			}
		}
		
		return todosCollected;
	}

	@Override
	public List<Todo> getTodos(boolean isChecked) {
		List<Todo> todosCollected = new ArrayList<Todo>();
		
		for (Todo todo : todos.values()) {
			if (todo.getChecked() == isChecked) {
				todosCollected.add(todo);
			}
		}
		
		return todosCollected;
	}

	@Override
	public List<Todo> getTodos(Date start, Date end) {
		List<Todo> todosCollected = new ArrayList<Todo>();
		
		for (Todo todo : todos.values()) {
			if (todo.getCreated().after(start) && todo.getCreated().before(end)) {
				todosCollected.add(todo);
			}
		}
		
		return todosCollected;
	}

	@Override
	public Todo updateTodoTitle(long id, String title) {
		Todo todo = getTodo(id);
		
		if (todo != null) {
			todo.setTitle(title);
			todo.setUpdated(new Date());
		}
		
		return todo;
	}

	@Override
	public Todo checkTodo(long id) {
		Todo todo = getTodo(id);
		
		if (todo != null) {
			todo.setChecked(true);
			todo.setUpdated(new Date());
		}
		
		return todo;
	}

	@Override
	public Todo uncheckTodo(long id) {
		Todo todo = getTodo(id);
		
		if (todo != null) {
			todo.setChecked(false);
			todo.setUpdated(new Date());
		}
		
		return todo;
	}

	@Override
	public Todo deleteTodo(long id) {
		return todos.remove(id);
	}
	
}
