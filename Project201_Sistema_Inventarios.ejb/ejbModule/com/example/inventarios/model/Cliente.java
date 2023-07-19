package com.example.inventarios.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {

	private Long clientId;
	private String nombre;
	private String apellidos;
	private String correo;
	private String direccion1;
	private String direccion2;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}

	@Override
	public String toString() {
		return "Cliente [clientId=" + clientId + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo="
				+ correo + ", direccion1=" + direccion1 + ", direccion2=" + direccion2 + "]";
	}

}
