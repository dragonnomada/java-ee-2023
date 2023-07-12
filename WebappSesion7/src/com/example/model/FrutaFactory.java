package com.example.model;

// UTIL*

public class FrutaFactory {

	public static Fruta build(int id, String nombre, double precio, 
			double pesoUnitario, int existencias) {
		Fruta fruta = new Fruta();
		
		if (id > 0) {
			fruta.setId(id);
		}
		
		fruta.setNombre(nombre);
		fruta.setPrecio(precio);
		fruta.setPesoUnitario(pesoUnitario);
		fruta.setExistencias(existencias);
		
		return fruta;
	}
	
}
