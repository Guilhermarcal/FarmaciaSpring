package com.cotemig.springBoot.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.springBoot.model.Venda;

public interface VendaService {
	Optional<Venda> getVendaById(Integer id);
	List<Venda> getAllVenda();
	void deleteAllVendas();
	void deleteVendaById(Integer id);
	void updateVendaById(Integer id, Venda venda);
	void updateVenda(Venda venda);
	void insertVenda(Venda venda);
}