package com.example.ejb;

import javax.ejb.Stateful;

@Stateful
public class HelloEJBServiceStateful {

	private int count = 0;
	private String title = "Hello world (Stateful)";

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
