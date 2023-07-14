package com.example.rs;

import java.util.List;

import javax.enterprise.context.RequestScoped;
//import javax.ejb.EJB;
import javax.inject.Inject;
//import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.model.Fruta;
import com.example.services.FrutaService;

// JAX-RS

// -> Web Container

//@Stateless
@Path("/frutas")
@RequestScoped
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
