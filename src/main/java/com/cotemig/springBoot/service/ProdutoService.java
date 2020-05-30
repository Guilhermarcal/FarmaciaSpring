package com.cotemig.springBoot.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.springBoot.model.Produto;

public interface ProdutoService {
	Optional<Produto> getProdutoById(Integer id);
	List<Produto> getAllProduto();
	void deleteAllProdutos();
	void deleteProdutoById(Integer id);
	void updateProdutoById(Integer id, Produto produto);
	void updateProduto(Produto produto);
	void insertProduto(Produto produto);
	String getNomeProduto(Integer id);
}