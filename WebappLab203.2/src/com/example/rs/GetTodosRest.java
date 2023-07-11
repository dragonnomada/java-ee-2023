package com.example.rs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Todo;
import com.example.service.TodoService;

@WebServlet(name = "getTodos", urlPatterns = { "/todos" })
public class GetTodosRest extends HttpServlet {

	private static final long serialVersionUID = 8203693185837285468L;
	
	@Inject 
	TodoService todoService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("todos", todoService.getTodos());
	    req.getRequestDispatcher("todos.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("content-type", "text/plain");
		
		PrintWriter writer = resp.getWriter();
		
		Todo[] todos = todoService.getTodos();
		
		for (Todo todo : todos) {
			long id = todo.getId();
			todoService.uncheckTodo(id);
			String check = req.getParameter(String.format("check:%d", id));
			if (check == null) {
				writer.printf("(off): %s %n", todo);
				continue;
			}
			todoService.checkTodo(id);
			writer.printf("(on) : %s %n", todo);
		}
	}
	
}
