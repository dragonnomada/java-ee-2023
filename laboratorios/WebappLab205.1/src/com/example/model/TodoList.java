package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TodoList {

	private List<Todo> todos = new ArrayList<>();
	
	@XmlElement(name="todo")
	public List<Todo> getTodos() {
		return todos;
	}
	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public void addTodo(Todo todo) {
		todos.add(todo);
	}
	
	@Override
	public String toString() {
		String result = "TodoList [todos=" + todos.size() + "]";
		for (Todo todo : todos) {
			result += "\n" + todo;
		}
		return result;
	}
	
}
