package com.example.test;

import com.example.model.Fruta;
import com.example.services.FrutaService;

// EJB Container

public class FrutaServiceTest {

	public static void main(String[] args) {
		
		FrutaService frutaService = new FrutaService();
		
		for (Fruta fruta : frutaService.getFrutas()) {
			System.out.println(fruta);
		}
		
	}
	
}
