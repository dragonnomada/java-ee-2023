package com.example.inventarios.service;

import java.util.List;

import com.example.inventarios.model.Cliente;

public interface ClienteService {

	Cliente agregarCliente(Cliente cliente);

	Cliente buscarCliente(long id);

	Cliente buscarCliente(String correo);

	Cliente buscarCliente(String nombre, String apellidos);

	List<Cliente> buscarClientes();

	List<Cliente> buscarClientesConPaquete();

	List<Cliente> buscarClientesConPaquete(boolean esEntrada);

	Cliente actualizarCliente(long transaccionId, Cliente cliente);

}
