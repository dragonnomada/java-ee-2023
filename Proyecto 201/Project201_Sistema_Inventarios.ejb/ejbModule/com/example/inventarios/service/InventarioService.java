package com.example.inventarios.service;

import java.util.List;

import com.example.inventarios.model.Paquete;

public interface InventarioService {

	Paquete registrarPaquete(long clienteId);

	Paquete recibirPaqueteEntrada(long paqueteId, long proveedorId);

	Paquete enviarPaqueteSalida(long paqueteId, long clienteId, long proveedorId);

	List<Paquete> buscarPaquetesEnPosesion();

	List<Paquete> buscarPaquetesPendientesProveedorEntrada();

	List<Paquete> buscarPaquetesPendientesEntrada();

	List<Paquete> buscarPaquetesPendientesProveedorSalida();

	List<Paquete> buscarPaquetesPendientesSalida();

}
