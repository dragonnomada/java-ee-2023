package com.example.service;

import java.util.List;

import com.example.model.Client;

public interface ClientService {

	Client addClient(Client client);
	
	Client getClient(long id);

	List<Client> getClients();
	
	Client updateClient(Client client);

	Client deleteClient(long id);
	
}
