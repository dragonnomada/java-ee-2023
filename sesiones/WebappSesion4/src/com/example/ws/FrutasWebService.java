package com.example.ws;

import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.example.model.Fruta;

@WebService(serviceName="frutasWebService")
public class FrutasWebService {

	Logger logger = Logger.getLogger("FrutasWebService");
	
	@WebMethod
	@WebResult(name="fruta")
	public Fruta agregarFruta(@WebParam(name="nombre") String nombre, @WebParam(name="precio") double precio) {
		Fruta fruta = new Fruta();
		
		fruta.setNombre(nombre); 
		fruta.setPrecio(precio);
		
		logger.info("Fruta recibida: " + fruta);
		
		return fruta;
	}
	
}
