package com.example.inventarios.service;

import java.util.List;

import com.example.inventarios.model.Proveedor;

public interface ProveedorService {

	Proveedor agregarProveedor(Proveedor cliente);

	Proveedor buscarProveedor(long id);

	Proveedor buscarProveedor(String rfc);

	Proveedor buscarProveedor(String razonSocial, String correo, String telefono);

	List<Proveedor> buscarProveedores();

	List<Proveedor> buscarProveedoresConPaquete();

	List<Proveedor> buscarProveedoresConPaquete(boolean esEntrada);

	Proveedor actualizarProveedor(long transaccionId, Proveedor cliente);

}
