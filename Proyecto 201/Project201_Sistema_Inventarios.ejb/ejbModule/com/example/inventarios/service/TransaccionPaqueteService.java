package com.example.inventarios.service;

import com.example.inventarios.model.TransaccionPaquete;

public interface TransaccionPaqueteService {

	TransaccionPaquete paqueteAsignarClienteEntrada(long paqueteId, long clienteId);

	TransaccionPaquete paqueteAsignarProveedorEntrada(long paqueteId, long proveedorId);

	TransaccionPaquete paqueteAsignarClienteSalida(long paqueteId, long clienteId);

	TransaccionPaquete paqueteAsignarProveedorSalida(long paqueteId, long proveedorId);

	TransaccionPaquete paqueteAsignarGuiaEntrada(long paqueteId, long proveedorId, String guia);

	TransaccionPaquete recibirPaqueteEntrada(long paqueteId, long proveedorId);

	TransaccionPaquete entregarPaqueteSalidaProveedor(long paqueteId, long proveedorId);

	TransaccionPaquete paqueteAsignarGuiaSalida(long paqueteId, long proveedorId, String guia);

	TransaccionPaquete entregarPaqueteSalidaCliente(long paqueteId, long proveedorId, long clienteId);

}
