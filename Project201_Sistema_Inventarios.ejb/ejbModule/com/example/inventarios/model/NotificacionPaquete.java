package com.example.inventarios.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NotificacionPaquete {

	private Long notificacionId;
	private Long paqueteId;
	private int tipoNotificacionId;
	private Double latitud;
	private Double longitud;
	private String titulo;
	private String contenido;
	private String metadatos;
	private Date fecha;
	private Boolean recibida;
	private Boolean abierta;
	private Boolean aceptada;

	public Long getNotificacionId() {
		return notificacionId;
	}

	public void setNotificacionId(Long notificacionId) {
		this.notificacionId = notificacionId;
	}

	public Long getPaqueteId() {
		return paqueteId;
	}

	public void setPaqueteId(Long paqueteId) {
		this.paqueteId = paqueteId;
	}

	public int getTipoNotificacionId() {
		return tipoNotificacionId;
	}

	public void setTipoNotificacionId(int tipoNotificacionId) {
		this.tipoNotificacionId = tipoNotificacionId;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getMetadatos() {
		return metadatos;
	}

	public void setMetadatos(String metadatos) {
		this.metadatos = metadatos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getRecibida() {
		return recibida;
	}

	public void setRecibida(Boolean recibida) {
		this.recibida = recibida;
	}

	public Boolean getAbierta() {
		return abierta;
	}

	public void setAbierta(Boolean abierta) {
		this.abierta = abierta;
	}

	public Boolean getAceptada() {
		return aceptada;
	}

	public void setAceptada(Boolean aceptada) {
		this.aceptada = aceptada;
	}

	@Override
	public String toString() {
		return "NotificacionPaquete [notificacionId=" + notificacionId + ", paqueteId=" + paqueteId
				+ ", tipoNotificacionId=" + tipoNotificacionId + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", titulo=" + titulo + ", contenido=" + contenido + ", metadatos=" + metadatos + ", fecha=" + fecha
				+ ", recibida=" + recibida + ", abierta=" + abierta + ", aceptada=" + aceptada + "]";
	}

}
