package com.example.ejb;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

@Stateless
@DeclareRoles({ "JEE_USER", "JEE_USER_PRO" })
@PermitAll
public class HelloService {

	int count = 0;

	@PermitAll
	public int getCount() {
		return ++count;
	}

	@RolesAllowed({ "JEE_USER" })
	public String getHello() {
		return "hello";
	}

	@RolesAllowed({ "JEE_USER_PRO" })
	public String getHelloPro() {
		return "hello pro";
	}

}
