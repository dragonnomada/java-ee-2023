package com.example.rs;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.example.model.Client;
import com.example.service.ClientService;
import com.example.service.ResourceClient;

@Path("/clients")
@Consumes("application/xml")
@Produces("application/xml")
@RequestScoped
public class ClientRest {
	
	@Inject
	@ResourceClient
	ClientService clientService;

	@GET
	public List<Client> getClients() {
		return clientService.getClients();
	}
	
	@GET
	@Path("/{id}")
	public Client getClient(@PathParam("id") long id) {
		return clientService.getClient(id);
	}
	
	@GET
	@Path("/insecure/add")
	public Client insecureAddClient(@QueryParam("firstName") String firstName, 
			@QueryParam("lastName") String lastName, 
			@QueryParam("address1") String address1,
			@QueryParam("address2") String address2,
			@QueryParam("phone") String phone,
			@QueryParam("email") String email) {
		Client client = new Client();
		client.setFirstName(firstName);
		client.setLastName(lastName);
		client.setAddress1(address1);
		client.setAddress2(address2);
		client.setPhone(phone);
		client.setEmail(email);
		return clientService.addClient(client);
	}
	
}
