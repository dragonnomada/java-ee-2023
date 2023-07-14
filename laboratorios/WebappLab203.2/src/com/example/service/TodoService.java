package com.example.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.example.model.Todo;
import com.example.model.TodoList;

@ManagedBean
@ApplicationScoped
public class TodoService {

	TodoList todoList = new TodoList();
	
	public Todo makeTodo(String title) {
		Todo todo = new Todo();
		todo.setId((long)todoList.getTodos().size());
		todo.setTitle(title);
		todo.setChecked(false);
		todo.setCreated(new Date());
		return todo;
	}
	
	public Todo getTodo(long id) {
		List<Todo> todos = todoList.getTodos();
		
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		
		return null;
	}
	
	public Todo[] getTodos() {
		List<Todo> todos = todoList.getTodos();
		Todo[] todosArray = new Todo[todos.size()];
		int i = 0;
		for (Todo todo : todos) {
			todosArray[i++] = todo;
		}
		return todosArray;
	}
	
	public Todo addTodo(String title) {
		Todo todo = makeTodo(title);
		todoList.addTodo(todo);
		return todo;
	}
	
	public Todo checkTodo(long id) {
		Todo todo = getTodo(id);
		
		if (todo != null) {
			todo.setChecked(true);
			todo.setUpdated(new Date());
		}
		
		return todo;
	}
	
	public Todo uncheckTodo(long id) {
		Todo todo = getTodo(id);
		
		if (todo != null) {
			todo.setChecked(false);
			todo.setUpdated(new Date());
		}
		
		return todo;
	}
	
	public void saveTodos() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(TodoList.class);
        
        Marshaller marshaller= context.createMarshaller();
        
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        marshaller.marshal(todoList, new File("./todos.xml"));
    }
	
	public void loadTodos() throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(TodoList.class);
	    
	    todoList = (TodoList) context.createUnmarshaller()
	      .unmarshal(new FileReader("./todos.xml"));
    }
	
}
