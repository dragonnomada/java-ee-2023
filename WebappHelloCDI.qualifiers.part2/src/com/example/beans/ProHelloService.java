package com.example.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.example.service.HelloService;
import com.example.service.ProHello;

@ProHello
@Named
@ApplicationScoped
public class ProHelloService implements HelloService {

	private int count;
	
	@Override
	public int getCount() {
		return (++count) % 2;
	}

	@Override
	public String sayHello() {
		return "Pro hello";
	}

}
