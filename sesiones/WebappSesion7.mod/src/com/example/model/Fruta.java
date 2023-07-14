package com.example.model;

import javax.xml.bind.annotation.XmlRootElement;

// ENTITY*

@XmlRootElement
public class Fruta {

	private Integer id;
	private String nombre;
	private Double precio;
	private Double pesoUnitario;
	private int existencias;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getPesoUnitario() {
		return pesoUnitario;
	}
	public void setPesoUnitario(Double pesoUnitario) {
		this.pesoUnitario = pesoUnitario;
	}
	public int getExistencias() {
		return existencias;
	}
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
	@Override
	public String toString() {
		return "Fruta [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", pesoUnitario=" + pesoUnitario
				+ ", existencias=" + existencias + "]";
	}
	
}
