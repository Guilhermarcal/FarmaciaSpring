package com.cotemig.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cotemig.springBoot.model.Venda;

@Repository("vendaRepository")
public interface VendaRepository extends JpaRepository<Venda, Integer> {
		
	@Query(value = "SELECT preco FROM produto WHERE id = ?1", nativeQuery = true)
	Double getPrecoProduto(Integer id);
	
}
