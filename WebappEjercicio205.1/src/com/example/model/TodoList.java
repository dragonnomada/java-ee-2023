package com.example.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="todos")
public class TodoList {

	private Todo[] todos;
	
	public TodoList() {
		
	}
	
	public TodoList(List<Todo> todos) {
		if (todos.size() > 0) {
			this.todos = new Todo[todos.size()];
			int i = 0;
			for (Todo todo : todos) {
				this.todos[i++] = todo;
			}
		}
	}
	
	@XmlElement(name="todo")
	public Todo[] getTodos() {
		return todos;
	}
	
	public static TodoList build(List<Todo> todos) {
		return new TodoList(todos);
	}
	
	public static void test1() throws JAXBException {
		List<Todo> todos = new ArrayList<Todo>();
		
		TodoList todoList = TodoList.build(todos);
		
		JAXBContext.newInstance(TodoList.class)
			.createMarshaller()
			.marshal(todoList, new File("todos-test1.xml"));
		
		System.out.println("Test 1 - PASSED");
	}
	
	public static void test2() throws JAXBException {
		List<Todo> todos = new ArrayList<Todo>();
		
		for (int i = 0; i < 10; i++) {
			Todo todo = new Todo();
			todo.setId(100L * i + 1);
			todo.setTitle(String.format("Todo %d", i));
			todo.setChecked(Math.random() >= 0.5);
			todo.setCreated(new Date());
			
			todos.add(todo);
		}
		
		TodoList todoList = TodoList.build(todos);
		
		JAXBContext.newInstance(TodoList.class)
			.createMarshaller()
			.marshal(todoList, new File("todos-test2.xml"));
		
		System.out.println("Test 2 - PASSED");
	}
	
	public static void main(String[] args) throws JAXBException {
		
		test1();
		test2();
		
	}
	
}
