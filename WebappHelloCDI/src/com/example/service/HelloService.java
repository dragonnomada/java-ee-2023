package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
public class HelloService {

	public String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd, MM yyyy");
        return formatter.format(new Date());
    }
	
}
