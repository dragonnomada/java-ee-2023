package com.example.service;

import javax.ejb.Stateless;

@SimpleHello
@Stateless
public class SimpleHelloService implements HelloService {

	int count = 0;
	
	@Override
	public int increment() {
		return ++count;
	}

	@Override
	public int decrement() {
		return --count;
	}

}
