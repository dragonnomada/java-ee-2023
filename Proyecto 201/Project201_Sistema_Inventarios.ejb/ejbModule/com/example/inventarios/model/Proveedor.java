package com.example.inventarios.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Proveedor {

	private Long proveedorId;
	private String nombre;
	private String rfc;
	private String razonSocial;
	private String direccion1;
	private String direccion2;
	private String correo;
	private String telefono;

	public Long getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(Long proveedorId) {
		this.proveedorId = proveedorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Proveedor [proveedorId=" + proveedorId + ", nombre=" + nombre + ", rfc=" + rfc + ", razonSocial="
				+ razonSocial + ", direccion1=" + direccion1 + ", direccion2=" + direccion2 + ", correo=" + correo
				+ ", telefono=" + telefono + "]";
	}

}
