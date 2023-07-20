package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

@ManagedBean
@ApplicationScoped
//@RequestScoped
public class HelloService {

	int count = 0;
	
	public String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd, MM yyyy");
        return formatter.format(new Date()) + " " + String.valueOf(++count);
    }
	
}
