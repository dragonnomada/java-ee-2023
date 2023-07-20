package com.example.inventarios.service;

import java.util.List;

import com.example.inventarios.model.Cliente;
import com.example.inventarios.model.Paquete;
import com.example.inventarios.model.Proveedor;

public interface PaqueteService {

	String generarGuia();

	Paquete agregarPaquete();

	Paquete buscarPaquete(long id);

	Paquete buscarPaquete(String guia);

	List<Paquete> buscarPaquetes();

	List<Paquete> buscarPaquetesByCliente(long clientId);

	List<Paquete> buscarPaquetesByProveedor(long proveedorId);

	List<Paquete> buscarPaquetesByCliente(long clientId, boolean esEntrada);

	List<Paquete> buscarPaquetesByProveedor(long proveedorId, boolean esEntrada);

	Paquete actualizarClienteEntrada(long transaccionId, Cliente cliente);

	Paquete actualizarClienteSalida(long transaccionId, Cliente cliente);

	Paquete actualizarProveedorEntrada(long transaccionId, Proveedor proveedor);

	Paquete actualizarProveedorSalida(long transaccionId, Proveedor proveedor);

	Paquete actualizarGuiaEntrada(long transaccionId, String guia);

	Paquete actualizarGuiaSalida(long transaccionId, String guia);

	Paquete ingresarPaquete(long transaccionId, long id);

	Paquete retirarPaquete(long transaccionId, long id);

}
