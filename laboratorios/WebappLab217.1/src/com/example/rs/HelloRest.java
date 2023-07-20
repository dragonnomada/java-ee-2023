package com.example.rs;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import com.example.ejb.HelloService;

@Path("/hello")
@Stateless
//@RequestScoped()
@DeclareRoles({ "JEE_USER", "JEE_USER_PRO" })
@PermitAll
public class HelloRest {

	@EJB
	HelloService helloService;

	@GET
	@RolesAllowed({ "JEE_USER" })
	public String main() {
		return "Count: " + helloService.getCount();
	}

	@GET
	@Path("/say")
	@RolesAllowed({ "JEE_USER" })
	public String sayHello() {
//		return "hello";
		return helloService.getHello();
	}
	
	@GET
	@Path("/say2")
//	@RolesAllowed({ "JEE_USER" })
	public String sayHello2(@Context SecurityContext context) {
		if (context.isUserInRole("JEE_USER")) {
			return "hello 2";
		}
		return "nope";
	}

	@GET
	@RolesAllowed({ "JEE_USER_PRO" })
	@Path("/pro")
	public String sayHelloPro() {
		return "hello pro";
//		return helloService.getHelloPro();
	}

}
