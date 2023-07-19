package com.example.rs;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.example.inventarios.model.Cliente;
import com.example.inventarios.service.ClienteService;

@Path("/clientes")
@RequestScoped
public class ClienteRest {

	@Inject
	ClienteService clienteService;
	
	@GET
	public List<Cliente> getClientes() {
		return clienteService.buscarClientes();
	}
	
}
