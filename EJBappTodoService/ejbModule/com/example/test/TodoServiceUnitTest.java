package com.example.test;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.model.Todo;
import com.example.service.LocalTodo;
import com.example.service.TodoService;

public class TodoServiceUnitTest {

	@EJB
	@LocalTodo
	TodoService todoService;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		System.out.println("Hola JUnit");
//		fail("No pasó la prueba unitaria");
//		throw new Exception("Error al hacer la prueba");
		
		assertNotNull("El TodoService no pudo ser inyectado", todoService);
		
		Todo todo = todoService.addTodo("Prueba 1");
		
		assertNotNull(todo);
		assertTrue(todo.getId() == 1L);
		assertTrue(todo.getTitle().equals("Prueba 1"));
		assertFalse(todo.getChecked());
	}

}
