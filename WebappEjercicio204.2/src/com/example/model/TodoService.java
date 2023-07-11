package com.example.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class TodoService {

	TodoConfig todoConfig = new TodoConfig();
	List<Todo> todos = new ArrayList<>();
	
	public TodoService() {
		todoConfig.setNextId(1L);
		todoConfig.setDefaultTitle("Sin título");
		todoConfig.setDefaultChecked(false);
		todoConfig.setDefaultDate(new Date(0));
		
		try {
			todoConfig = (TodoConfig) JAXBContext
					.newInstance(TodoConfig.class)
					.createUnmarshaller()
					.unmarshal(new FileReader("todo-config.xml"));
		} catch (FileNotFoundException | JAXBException e) {
			System.out.println("No se pudieron leer las configuraciones de todo-config.xml");
			System.out.println("Crea el archivo todo-config.xml");
			System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
			System.out.println("<todoConfig nextId=\"1\" defaultChecked=\"false\">");
			System.out.println("	<defaultTitle>SIN TÍTULO</defaultTitle>");
			System.out.println("	<defaultDate>1970-01-01T00:00:00</defaultDate>");
			System.out.println("</todoConfig>");
		}
	}
	
	public void addTodoWithDefaults() {
		Todo todo = new Todo();
		
		todo.setId(todoConfig.getNextId());
		todo.setTitle(todoConfig.getDefaultTitle());
		todo.setChecked(todoConfig.getDefaultChecked());
		todo.setCreated(todoConfig.getDefaultDate());
		
		todos.add(todo);
		
		todoConfig.setNextId(todoConfig.getNextId() + 1);
		
		try {
			JAXBContext.newInstance(TodoConfig.class)
				.createMarshaller()
				.marshal(todoConfig, new File("todo-config.xml"));
		} catch (JAXBException e) {
			System.out.println("No se pudo actualizar la configuración");
		}
	}
	
	@Override
	public String toString() {
		return "TodoService [todoConfig=" + todoConfig + ", todos=" + todos + "]";
	}
	
	public static void main(String[] args) {
		TodoService todoService = new TodoService();
		
		System.out.println(todoService);
		
		for (int i = 0; i < 5; i++) {
			todoService.addTodoWithDefaults();
		}
		
		System.out.println(todoService);
	}
	
}
