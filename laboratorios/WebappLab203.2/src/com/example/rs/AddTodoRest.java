package com.example.rs;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import com.example.model.Todo;
import com.example.service.TodoService;

@WebServlet(name = "addTodo", urlPatterns = { "/addTodo" })
public class AddTodoRest extends HttpServlet {

	private static final long serialVersionUID = -1371341278351625953L;
	
	@Inject 
	TodoService todoService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("todos", todoService.getTodos());
	    req.getRequestDispatcher("addTodo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = (String) req.getParameter("title");
		Todo todo = todoService.addTodo(title);
		resp.setHeader("content-type", "text/plain");
		try {
			todoService.saveTodos();
			resp.getWriter().printf("ok %s %n", todo);
		} catch (JAXBException e) {
			resp.getWriter().write(e.getMessage());
		}
	}
}
