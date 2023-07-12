package com.example.rs;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.services.JDBCServiceLocal;

@WebServlet(name = "jdbcTestLocal", urlPatterns = { "/jdbcTestLocal" })
public class JDBCTestLocalRS extends HttpServlet {

	private static final long serialVersionUID = -5056581203052682927L;
	
	@Inject
	JDBCServiceLocal jdbcService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("content-type", "text/plain");
		try {
			resp.getWriter().println("LOCAL");
			resp.getWriter().println(jdbcService.test());
		} catch (SQLException e) {
			resp.getWriter().println(e.getMessage());
		}
	}
	
}
