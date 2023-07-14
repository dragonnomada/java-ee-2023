package com.example.rs;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.model.Fruta;

@Path("/hello")
public class HelloRS {
	
	Logger logger = Logger.getLogger("HelloRS");

	@GET
	public String hello() {
		return "Hola mundo";
	}
	
	@GET
	@Path("/2")
	public Response hello2() {
		return Response.status(500).entity("Hola mundo 2").build();
	}
	
	@GET
	@Path("/fruta")
	@Produces(MediaType.APPLICATION_XML) // JAXB
	public Fruta sampleFruta() {
		Fruta fruta = new Fruta();
		fruta.setId(123l);
		fruta.setNombre("Manzana");
		fruta.setPeso(402d);
		fruta.setPrecio(19.99d);
		
		return fruta;
	}
	
	@GET
	@Path("/frutas")
	@Produces(MediaType.APPLICATION_XML) // JAXB
	public List<Fruta> sampleFrutas() {
		List<Fruta> frutas = new ArrayList<Fruta>();
		
		for (int i = 0; i < 10; i++) {
			Fruta fruta = new Fruta();
			fruta.setId(i + 100L);
			fruta.setNombre(String.format("Mi fruta %d", i + 1));
			fruta.setPeso(100.0 * (i + 1));
			fruta.setPrecio(99.99 - i * 9.87);
			frutas.add(fruta);
		}
		
		return frutas;
	}
	
	@POST
	@Path("/fruta/nueva")
	@Consumes(MediaType.APPLICATION_XML)
	public String getFruta(Fruta fruta) {
		logger.info("Se recibió una fruta: " + fruta.toString());
		return fruta.toString();
	}
	
}
