package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.example.model.Fruta;

@ManagedBean
@ApplicationScoped
public class FrutaService {

	long nextId = 1;
	List<Fruta> frutas = new ArrayList<Fruta>();
	
	public Fruta addFruta(String nombre, double precio) {
		Fruta fruta = new Fruta();
		fruta.setId(nextId++);
		fruta.setNombre(nombre);
		fruta.setPrecio(precio);
		fruta.setExistencias(0);
		fruta.setPeso(0.0);
		
		frutas.add(fruta);
		
		return fruta;
	}
	
	public Fruta[] getFrutas() {
		Fruta[] frutasArray = new Fruta[frutas.size()];
		
		int i = 0;
		for (Fruta fruta : frutas) {
			frutasArray[i++] = fruta;
		}
		
		return frutasArray;
	}
	
	public Fruta getFruta(long id) {
		for (Fruta fruta : frutas) {
			if (fruta.getId() == id) {
				return fruta;
			}
		}
		
		return null;
	}
	
	public Fruta updateFrutaNombre(long id, String nombre) {
		Fruta fruta = getFruta(id);
		
		if (fruta == null) return null;
		
		fruta.setNombre(nombre);
		
		return fruta;
	}
	
	public Fruta updateFrutaPrecio(long id, double precio) {
		Fruta fruta = getFruta(id);
		
		if (fruta == null) return null;
		
		fruta.setPrecio(precio);
		
		return fruta;
	}
	
	public Fruta updateFrutaPeso(long id, double peso) {
		Fruta fruta = getFruta(id);
		
		if (fruta == null) return null;
		
		fruta.setPeso(peso);
		
		return fruta;
	}
	
	public Fruta updateFrutaExistencias(long id, int existencias) {
		Fruta fruta = getFruta(id);
		
		if (fruta == null) return null;
		
		fruta.setExistencias(existencias);
		
		return fruta;
	}
	
	public Fruta deleteFruta(long id) {
		Fruta fruta = getFruta(id);
		
		if (fruta == null) return null;
		
		frutas.remove(fruta);
		
		return fruta;
	}
	
}



