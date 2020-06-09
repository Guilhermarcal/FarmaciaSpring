package com.cotemig.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.springBoot.model.Venda;
import com.cotemig.springBoot.repository.VendaRepository;

@Service("vendaService")
public class VendaServiceImpl implements VendaService {
	
	@Autowired
	VendaRepository vendaRepository;

	@Override
	public Optional<Venda> getVendaById(Integer id) {
		return vendaRepository.findById(id);
	}

	@Override
	public List<Venda> getAllVenda() {
		return vendaRepository.findAll();
	}

	@Override
	public void deleteAllVendas() {
		vendaRepository.deleteAll();
	}

	@Override
	public void deleteVendaById(Integer id) {
		vendaRepository.deleteById(id);
	}

	@Override
	public void updateVendaById(Integer id, Venda venda) {
				
		Optional<Venda> getVenda = getVendaById(id);
		getVenda.get().setClientes(venda.getClientes());
		getVenda.get().setFuncionarios(venda.getFuncionarios());
		getVenda.get().setProdutos(venda.getProdutos());
		getVenda.get().setQuantidade(venda.getQuantidade());
		getVenda.get().setData_venda(venda.getData_venda());
		
		vendaRepository.save(venda);
	}

	@Override
	public void updateVenda(Venda venda) {
		vendaRepository.save(venda);
	}

	@Override
	public void insertVenda(Venda venda) {				
		vendaRepository.save(venda);
	}
	
}