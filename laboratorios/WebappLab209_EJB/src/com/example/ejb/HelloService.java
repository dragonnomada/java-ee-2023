package com.example.ejb;

import java.io.Serializable;

//import javax.annotation.ManagedBean;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

//@ManagedBean
@Named
@ConversationScoped
public class HelloService implements Serializable {

	private static final long serialVersionUID = 7251093062668657045L;

	private int count = 0;
	private String title = "Hello world (Singleton)";

	public String getTitle() {
		int result = 0;

		for (int i = 0; i < 100_000; i++) {
			for (int j = 0; j < 10_000; j++) {
				result += (i % 5 - j % 3 + 3) % 2;
			}
		}

		return String.format("%s (%d) [%d]", title, ++count, result);
	}

}
