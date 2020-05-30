package com.cotemig.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cotemig.springBoot.model.Produto;

@Repository("produtoRepository")
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Query(value = "SELECT nome FROM PRODUTO WHERE id = ?1", nativeQuery = true)
	String getNomeProduto(Integer id);
	
}
