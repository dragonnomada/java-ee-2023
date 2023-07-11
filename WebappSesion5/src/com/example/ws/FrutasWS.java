package com.example.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.example.model.Fruta;
import com.example.service.FrutaService;

@WebService(serviceName="FrutasWS")
public class FrutasWS {

	@Inject
	FrutaService frutaService;
	
	@WebMethod
	@WebResult(name="fruta")
	public Fruta[] getAllFrutas() {
		return frutaService.getFrutas();
	}
	
	@WebMethod
	@WebResult(name="fruta")
	public Fruta getFrutaById(@WebParam(name="id") long id) {
		return frutaService.getFruta(id);
	}
	
	@WebMethod
	@WebResult(name="fruta")
	public Fruta addFruta(
			@WebParam(name="nombre") String nombre, 
			@WebParam(name="precio") double precio) {
		
		return frutaService.addFruta(nombre, precio);
		
	}
	
	@WebMethod
	@WebResult(name="fruta")
	public Fruta updateFruta(
			@WebParam(name="id") long id, 
			@WebParam(name="nombre") String nombre, 
			@WebParam(name="precio") double precio,
			@WebParam(name="peso") double peso,
			@WebParam(name="existencias") int existencias) {
		
		Fruta fruta;
		
		fruta = frutaService.updateFrutaNombre(id, nombre);
		fruta = frutaService.updateFrutaPrecio(id, precio);
		fruta = frutaService.updateFrutaPeso(id, peso);
		fruta = frutaService.updateFrutaExistencias(id, existencias);
		
		return fruta;
		
	}
	
	@WebMethod
	@WebResult(name="fruta")
	public Fruta deleteFruta(@WebParam(name="id") long id) {
		return frutaService.deleteFruta(id);
	}
}
