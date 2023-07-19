package com.example.inventarios.ejb;

import java.util.logging.Logger;

import com.example.inventarios.model.TransaccionPaquete;
import com.example.inventarios.service.TransaccionPaqueteService;

public class DefaultTransaccionPaqueteService implements TransaccionPaqueteService {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public TransaccionPaquete paqueteAsignarClienteEntrada(long paqueteId, long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransaccionPaquete paqueteAsignarProveedorEntrada(long paqueteId, long proveedorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransaccionPaquete paqueteAsignarClienteSalida(long paqueteId, long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransaccionPaquete paqueteAsignarProveedorSalida(long paqueteId, long proveedorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransaccionPaquete paqueteAsignarGuiaEntrada(long paqueteId, long proveedorId, String guia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransaccionPaquete recibirPaqueteEntrada(long paqueteId, long proveedorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransaccionPaquete entregarPaqueteSalidaProveedor(long paqueteId, long proveedorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransaccionPaquete paqueteAsignarGuiaSalida(long paqueteId, long proveedorId, String guia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransaccionPaquete entregarPaqueteSalidaCliente(long paqueteId, long proveedorId, long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

}
