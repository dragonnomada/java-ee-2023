package com.example.test;

import static org.junit.Assert.*;

import java.util.List;

//import javax.ejb.EJB;
//import javax.ejb.embeddable.EJBContainer;
//import javax.naming.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.ejb.LocalTodoService;
import com.example.model.Todo;
import com.example.service.TodoService;

public class TodoServiceUnitTest {

	// EJBContainer ejbContainer;
	// Context context;

	static TodoService todoService;

	@Before
	public void setUp() throws Exception {
		// ejbContainer = EJBContainer.createEJBContainer();
		// context = ejbContainer.getContext();
		// todoService = (TodoService)
		// context.lookup("java:global/classes/LocalTodoService");
		todoService = new LocalTodoService();
	}

	@After
	public void tearDown() throws Exception {
		// ejbContainer.close();
	}

	@Test
	public void test() throws Exception {
		assertNotNull("El TodoService no pudo ser inyectado", todoService);

		{ // Test Add Todo
			for (int i = 0; i < 10; i++) {
				Todo todo = todoService.addTodo(String.format("Todo %d", i + 1));

				assertNotNull("El todo creado es null", todo);
				assertTrue("El todo no tiene id = " + (i + 1), todo.getId() == (i + 1));
				assertTrue("El todo no tiene el título correcto: " + todo.getTitle(),
						todo.getTitle().equals("Todo " + (i + 1)));
				assertFalse("El todo está checked", todo.getChecked());

				System.out.println(todo);
			}
		}

		{ // Test Get Todo (1)
			assertNotNull("El TodoService no pudo ser inyectado", todoService);

			Todo todo = todoService.getTodo(1L);

			assertNotNull("El todo es null", todo);
			assertTrue("El todo tiene mal su título", todo.getTitle().equals("Todo 1"));
		}

		{ // Test Get Todo (10)
			Todo todo = todoService.getTodo(10L);

			assertNotNull("El todo es null", todo);
			assertTrue("El todo tiene mal su título", todo.getTitle().equals("Todo 10"));
		}

		{ // Test Get Todo (11)
			Todo todo = todoService.getTodo(11L);

			assertNull("El todo no es null", todo);
		}
		
		{ // Todo Check Todo
			todoService.checkTodo(5L);
			
			Todo todo = todoService.getTodo(5L);
			
			assertNotNull("El todo es null", todo);
			assertTrue("El todo no está checked", todo.getChecked());
		}
		
		{ // Todo Get Todos Checked
			List<Todo> todos = todoService.getTodos(true);
			
			assertTrue("Hay demasiados o pocos todos checked", 
					todos.size() == 1);
			assertTrue("El todo no es el de id = 5",
					todos.get(0).getId() == 5L);
		}
		
		// Checar que funcionen bien otros métodos del servicio

	}

}
