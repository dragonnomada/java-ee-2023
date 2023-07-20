package com.example.inventarios.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Paquete {

	private Long paqueteId;
	private String guia;
	private Long clienteEntradaId;
	private Long proveedorEntradaId;
	private String guiaEntrada;
	private Date fechaEntrada;
	private Long clienteSalidaId;
	private Long proveedorSalidaId;
	private String guiaSalida;
	private Date fechaSalida;
	private Boolean posesion;

	public Long getPaqueteId() {
		return paqueteId;
	}

	public void setPaqueteId(Long paqueteId) {
		this.paqueteId = paqueteId;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public Long getClienteEntradaId() {
		return clienteEntradaId;
	}

	public void setClienteEntradaId(Long clienteEntradaId) {
		this.clienteEntradaId = clienteEntradaId;
	}

	public Long getProveedorEntradaId() {
		return proveedorEntradaId;
	}

	public void setProveedorEntradaId(Long proveedorEntradaId) {
		this.proveedorEntradaId = proveedorEntradaId;
	}

	public String getGuiaEntrada() {
		return guiaEntrada;
	}

	public void setGuiaEntrada(String guiaEntrada) {
		this.guiaEntrada = guiaEntrada;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Long getClienteSalidaId() {
		return clienteSalidaId;
	}

	public void setClienteSalidaId(Long clienteSalidaId) {
		this.clienteSalidaId = clienteSalidaId;
	}

	public Long getProveedorSalidaId() {
		return proveedorSalidaId;
	}

	public void setProveedorSalidaId(Long proveedorSalidaId) {
		this.proveedorSalidaId = proveedorSalidaId;
	}

	public String getGuiaSalida() {
		return guiaSalida;
	}

	public void setGuiaSalida(String guiaSalida) {
		this.guiaSalida = guiaSalida;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Boolean getPosesion() {
		return posesion;
	}

	public void setPosesion(Boolean posesion) {
		this.posesion = posesion;
	}

	@Override
	public String toString() {
		return "Paquete [paqueteId=" + paqueteId + ", guia=" + guia + ", clienteEntradaId=" + clienteEntradaId
				+ ", proveedorEntradaId=" + proveedorEntradaId + ", guiaEntrada=" + guiaEntrada + ", fechaEntrada="
				+ fechaEntrada + ", clienteSalidaId=" + clienteSalidaId + ", proveedorSalidaId=" + proveedorSalidaId
				+ ", guiaSalida=" + guiaSalida + ", fechaSalida=" + fechaSalida + ", posesion=" + posesion + "]";
	}

}
