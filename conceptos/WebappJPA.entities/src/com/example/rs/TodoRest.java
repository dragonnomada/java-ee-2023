package com.example.rs;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.example.entity.Todo;
import com.example.jpa.TodoService;

@Path("/todo")
@Produces("application/xml")
@Stateless
public class TodoRest {

	@Inject
	TodoService todoService;
	
	@GET
	public List<Todo> getTodos() {
		return todoService.getTodos();
	}
	
	@GET
	@Path("/insecure/add")
	public Todo addTodo(@QueryParam("title") String title) {
		return todoService.addTodo(title);
	}
	
}
