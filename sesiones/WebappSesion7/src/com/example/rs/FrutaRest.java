package com.example.rs;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.model.Fruta;
import com.example.services.FrutaService;

// JAX-RS

// -> Web Container

//@Stateless
@Path("/frutas")
public class FrutaRest {

	//@EJB // @Inject // @Resource
	@Inject
	FrutaService frutaService; // Accede a la refencia del servicio
	
	@GET
	@Produces("application/xml")
	public List<Fruta> getFrutas() {
		return frutaService.getFrutas();
	}
	
}
