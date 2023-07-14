package com.example.beans;

import javax.ejb.Stateless;

@Stateless
public class HelloBean {

	private int count = 0;
	
	public String sayHello(String name) {
		return String.format("Hello, %s (%d)", name, count++);
	}
	
}
