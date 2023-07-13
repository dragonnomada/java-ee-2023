package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// La anotación equivale a configurar el web.xml
// indicando el <servlet-name> y demás
@WebServlet(name="HelloServlet", urlPatterns={ "/hello" })
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 8655324001834130179L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		resp.getWriter().printf("Hello, %s", name);
	}
	
}
