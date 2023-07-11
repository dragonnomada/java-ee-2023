package com.example.rs;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import com.example.service.TodoService;

@WebServlet(name = "loadTodos", urlPatterns = { "/loadTodos" })
public class LoadTodosRest extends HttpServlet {

	private static final long serialVersionUID = 1084563223011698323L;
	
	@Inject
	TodoService todoService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("todos.jsp").forward(req, resp);
		resp.setHeader("content-type", "text/plain");
		try {
			todoService.loadTodos();
			resp.getWriter().write("ok");
		} catch (JAXBException e) {
			resp.getWriter().write(e.getMessage());
		}
	}

}
