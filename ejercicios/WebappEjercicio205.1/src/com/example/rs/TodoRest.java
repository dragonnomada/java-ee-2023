package com.example.rs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.model.Todo;
import com.example.model.TodoList;

// JAX-RS

// -> EJB (@Stateless, @Singleton, @Stateful | @ApplicationScoped, @SessionScoped, @RequestScoped)
@ApplicationScoped
@Path("/todos")
public class TodoRest {

	// Servicio de Todos (o retener los nuestros)
	List<Todo> todos = new ArrayList<Todo>();
	long nextId = 1;
	
	@GET // Controlamos bajo la ruta un método HTTP tipo GET
	@Produces(MediaType.APPLICATION_XML) // Mime-Type de la respuesta al cliente
	public TodoList getAll() {
		return TodoList.build(todos);
	}
	
	@GET // Controlamos bajo la ruta un método HTTP tipo GET
	@Produces(MediaType.APPLICATION_XML) // Mime-Type de la respuesta al cliente
	@Path("/{id}") // Ruta dinámica con parámetro 'id' sobre la ruta
	public Todo getById(@PathParam("id") long id) { // Recuperar el 'id' de la ruta
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	@POST // Controlamos bajo la ruta un método HTTP tipo POST
	@Consumes("application/xml") // Mime-Type equivalente a MediaType.APPLICATION_XML
	@Produces("application/xml")
	@Path("/add")
	public Todo add(Todo todo) { // Esperamos recibir un todo desde el cliente
		todo.setId(nextId++);
		todo.setCreated(new Date());
		todo.setUpdated(null);
		
		if (todo.getTitle() == null) {
			todo.setTitle("Sin título");
		}
		
		if (todo.getChecked() == null) {
			todo.setChecked(false);
		}
		
		todos.add(todo);
		
		return todo;
	}
	
	// TODO: Continuar con los demás servicios REST 
	//       (PUT - actualizar, DELETE - eliminar)
	
}

/*
 * MÉTODOS HTTP PARA RESTFUL:
 * 
 * GET - Acepta peticiones sobre la url: URL:  http://.../api/todos?isChecked=true
 * 
 * POST - Acepta peticiones bajo la url. URL:  http://.../api/todos
 * 										 BODY: <todo>...</todo>
 * 
 * PUT -> Actualiza un recurso existente (/todos/123)
 * 
 * PATCH -> Actualiza un recurso existe, bajo una demanda (/todos/123?token=abc123)
 * 
 * DELETE -> Elimina un recurso (/todos/123)
 * 
 */
