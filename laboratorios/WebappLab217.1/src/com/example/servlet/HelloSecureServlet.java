package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloSecureServlet", urlPatterns = { "/secure/hello" })
@ServletSecurity(@HttpConstraint(transportGuarantee = TransportGuarantee.CONFIDENTIAL, rolesAllowed = { "SECURE_TEST",
		"JEE_USER" }))
public class HelloSecureServlet extends HttpServlet {

	private static final long serialVersionUID = -3043490040514559372L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.addHeader("content-type", "text/plain");

		PrintWriter writer = resp.getWriter();

		writer.println("Secure hello :D");
	}

}
