package com.example.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fruta {
	
	private Long id;
	private String nombre;
	private Double precio;
	private Integer existencias;
	private Double peso;
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Integer getExistencias() {
		return existencias;
	}
	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	@XmlElement
	public String getDescription() {
		return toString();
	}
	
	@Override
	public String toString() {
		return "Fruta [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", existencias=" + existencias
				+ ", peso=" + peso + "]";
	}
}
