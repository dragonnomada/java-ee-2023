package com.example.inventarios.ejb;

import java.util.List;
import java.util.logging.Logger;

import com.example.inventarios.model.Paquete;
import com.example.inventarios.service.InventarioService;

public class DefaultInventarioService implements InventarioService {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public Paquete registrarPaquete(long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete recibirPaqueteEntrada(long paqueteId, long proveedorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete enviarPaqueteSalida(long paqueteId, long clienteId, long proveedorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> buscarPaquetesEnPosesion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> buscarPaquetesPendientesProveedorEntrada() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> buscarPaquetesPendientesEntrada() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> buscarPaquetesPendientesProveedorSalida() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> buscarPaquetesPendientesSalida() {
		// TODO Auto-generated method stub
		return null;
	}

}
