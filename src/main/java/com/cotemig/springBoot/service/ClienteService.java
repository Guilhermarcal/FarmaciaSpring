package com.cotemig.springBoot.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.springBoot.model.Cliente;

public interface ClienteService {
	Optional<Cliente> getClienteById(Integer id);
	List<Cliente> getAllCliente();
	void deleteAllClientes();
	void deleteClienteById(Integer id);
	void updateClienteById(Integer id, Cliente cliente);
	void updateCliente(Cliente cliente);
	void insertCliente(Cliente cliente);
	String getNomeCliente(Integer id);
}