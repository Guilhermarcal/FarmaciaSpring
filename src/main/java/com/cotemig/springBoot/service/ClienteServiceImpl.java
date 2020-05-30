package com.cotemig.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.springBoot.model.Cliente;
import com.cotemig.springBoot.repository.ClienteRepository;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Optional<Cliente> getClienteById(Integer id) {
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}

	@Override
	public void deleteAllClientes() {
		clienteRepository.deleteAll();
	}

	@Override
	public void deleteClienteById(Integer id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public void updateClienteById(Integer id, Cliente cliente) {
		Optional<Cliente> getCliente = getClienteById(id);
		getCliente.get().setName(cliente.getName());
		getCliente.get().setCpf(cliente.getCpf());
		getCliente.get().setEmail(cliente.getEmail());
		getCliente.get().setTelefone(cliente.getTelefone());
		
		clienteRepository.save(cliente);
	}

	@Override
	public void updateCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public void insertCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}	
	
	@Override
	public String getNomeCliente(Integer id) {
		return clienteRepository.getNomeCliente(id);
	}
	
}
