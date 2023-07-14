package com.example.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;

@Stateless
public class EnterpriseHelloService implements HelloService {

	Logger logger = Logger.getLogger("EnterpriseHelloSerive");
	
	int count = 0;
	int step = 5;
	
	@Override
	public int increment() {
		logger.info("Increment count: " + count);
		count += step;
		logger.info("Incremented count: " + count);
		return count;
	}

	@Override
	public int decrement() {
		logger.info("Decrement count: " + count);
		count -= step;
		logger.info("Decremented count: " + count);
		return count;
	}

}
