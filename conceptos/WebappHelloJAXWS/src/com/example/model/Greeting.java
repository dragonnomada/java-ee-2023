package com.example.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

// SOAP -> Literal

@XmlRootElement
public class Greeting {

	private String title;
	
	public Greeting() {
		title = "Hello, you";
	}
	
	public Greeting(String name) {
		title = String.format("Hello, %s", name);
	}

	@XmlElement
	public String getTitle() {
		return title;
	}
	
}
