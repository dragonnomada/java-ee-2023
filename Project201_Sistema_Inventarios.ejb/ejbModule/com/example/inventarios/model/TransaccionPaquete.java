package com.example.inventarios.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransaccionPaquete {

	private Long transaccionId;
	private Long paqueteId;
	private Long clienteId;
	private Long proveedorId;
	private int tipoTransaccionId;
	private Date fecha;

	public Long getTransaccionId() {
		return transaccionId;
	}

	public void setTransaccionId(Long transaccionId) {
		this.transaccionId = transaccionId;
	}

	public Long getPaqueteId() {
		return paqueteId;
	}

	public void setPaqueteId(Long paqueteId) {
		this.paqueteId = paqueteId;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(Long proveedorId) {
		this.proveedorId = proveedorId;
	}

	public int getTipoTransaccionId() {
		return tipoTransaccionId;
	}

	public void setTipoTransaccionId(int tipoTransaccionId) {
		this.tipoTransaccionId = tipoTransaccionId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "TransaccionPaquete [transaccionId=" + transaccionId + ", paqueteId=" + paqueteId + ", clienteId="
				+ clienteId + ", proveedorId=" + proveedorId + ", tipoTransaccionId=" + tipoTransaccionId + "]";
	}

}
