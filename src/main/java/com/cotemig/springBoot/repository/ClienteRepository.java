package com.cotemig.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cotemig.springBoot.model.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query(value = "SELECT nome FROM CLIENTE WHERE id = ?1", nativeQuery = true)
	String getNomeCliente(Integer id);
	
}
