package com.example.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.example.service.HelloService;
import com.example.service.SimpleHello;

// Web Beans -> @Managed | @Named + @ApplicationScoped | @SessionScoped | RequestScoped

// EJB Beans -> @Singleton | @Stateless | @Stateful

@SimpleHello
@Named
@ApplicationScoped
public class SimpleHelloService implements HelloService {

	private int count = 0;
	
	@Override
	public int getCount() {
		return ++count;
	}

	@Override
	public String sayHello() {
		return "Simple hello";
	}
	
}
