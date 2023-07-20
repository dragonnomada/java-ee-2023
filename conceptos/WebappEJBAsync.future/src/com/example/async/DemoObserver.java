package com.example.async;

import javax.ejb.Stateless;

@Stateless
public class DemoObserver {

	int count = 0;

	public int getCount() {
		return count;
	}
	
	public void increment() {
		++count;
	}
	
	public void reset() {
		count = 0;
	}

	
}
