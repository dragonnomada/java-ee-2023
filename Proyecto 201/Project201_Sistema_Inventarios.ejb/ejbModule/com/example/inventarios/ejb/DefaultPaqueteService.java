package com.example.inventarios.ejb;

import java.util.List;
import java.util.logging.Logger;

import com.example.inventarios.model.Cliente;
import com.example.inventarios.model.Paquete;
import com.example.inventarios.model.Proveedor;
import com.example.inventarios.service.PaqueteService;

public class DefaultPaqueteService implements PaqueteService {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public String generarGuia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete agregarPaquete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete buscarPaquete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete buscarPaquete(String guia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> buscarPaquetes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> buscarPaquetesByCliente(long clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> buscarPaquetesByProveedor(long proveedorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> buscarPaquetesByCliente(long clientId, boolean esEntrada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> buscarPaquetesByProveedor(long proveedorId, boolean esEntrada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete actualizarClienteEntrada(long transaccionId, Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete actualizarClienteSalida(long transaccionId, Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete actualizarProveedorEntrada(long transaccionId, Proveedor proveedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete actualizarProveedorSalida(long transaccionId, Proveedor proveedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete actualizarGuiaEntrada(long transaccionId, String guia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete actualizarGuiaSalida(long transaccionId, String guia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete ingresarPaquete(long transaccionId, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete retirarPaquete(long transaccionId, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
