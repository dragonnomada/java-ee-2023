package com.example.rs;

import java.io.IOException;
import java.util.Date;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import com.example.ejb.HelloService;

@Path("/hello")
@RequestScoped
public class HelloRest {

	@EJB
	HelloService helloService;

	@GET
	@Path("/insecure/login")
	public String login(@QueryParam("user") String user, @QueryParam("password") String password,
			@Context HttpServletRequest request) {
		try {
			request.login(user, password);
			return "OK - " + new Date();
		} catch (ServletException e) {
			return e.getMessage() + " - " + new Date() + " [" + user + "] (" + password + ")";
		}
	}

	@GET
	@Path("/insecure/logout")
	public String logout(@Context HttpServletRequest request) {
		try {
			request.logout();
			return "OK - " + new Date();
		} catch (ServletException e) {
			return e.getMessage();
		}
	}

	@GET
	@Path("/insecure/authenticate")
	public String authenticate(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			request.authenticate(response);
			return "OK - " + new Date();
		} catch (ServletException | IOException e) {
			return e.getMessage();
		}
	}

	@GET
	@PermitAll
	public String main() {
		return "Hello :)";
	}

	@GET
	@Path("/2")
	public String main2(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			if (request.authenticate(response)) {
				return "Hello 2 :)";
			} else {
				return "Nope 2 :/";
			}
		} catch (Exception e) {
			return e.getMessage() + " - " + new Date();
		}
	}

	@GET
	@Path("/3")
	public String main3(@Context HttpServletRequest request) {
		if (request.isUserInRole("JEE_USER")) {
			return "Hello 3 :)";
		} else {
			return "Nope 3 :/";
		}
	}
	
	@GET
	@Path("/4")
	public String main4(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			if (request.authenticate(response)) {
				if (request.isUserInRole("JEE_USER")) {
					return "Hello 4 :)";
				} else {
					return "Nope 4 :/";
				}
			} else {
				return "Nope 4 :(";
			}
		} catch (Exception e) {
			return e.getMessage() + " - " + new Date();
		}
	}

	@GET
	@Path("/count")
	public String getCount() {
		return "Count: " + helloService.getCount();
	}

	@GET
	@Path("/say")
	public String sayHello(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			if (request.authenticate(response)) {
				if (request.isUserInRole("JEE_USER")) {
					return helloService.getHello();
				} else {
					return "Nope SAY :/";
				}
			} else {
				return "Nope SAY :(";
			}
		} catch (Exception e) {
			return e.getMessage() + " - " + new Date();
		}
	}

	@GET
	@Path("/pro")
	public String sayHelloPro(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			if (request.authenticate(response)) {
				if (request.isUserInRole("JEE_USER_PRO")) {
					return helloService.getHelloPro();
				} else {
					return "Nope PRO :/";
				}
			} else {
				return "Nope PRO :(";
			}
		} catch (Exception e) {
			return e.getMessage() + " - " + new Date();
		}
	}

}
