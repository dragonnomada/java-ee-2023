package com.example.inventarios.ejb;

import java.util.List;
import java.util.logging.Logger;

import com.example.inventarios.model.Proveedor;
import com.example.inventarios.service.ProveedorService;

public class DefaultProveedorService implements ProveedorService {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public Proveedor agregarProveedor(Proveedor cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor buscarProveedor(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor buscarProveedor(String rfc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor buscarProveedor(String razonSocial, String correo, String telefono) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proveedor> buscarProveedores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proveedor> buscarProveedoresConPaquete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proveedor> buscarProveedoresConPaquete(boolean esEntrada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor actualizarProveedor(long transaccionId, Proveedor cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
