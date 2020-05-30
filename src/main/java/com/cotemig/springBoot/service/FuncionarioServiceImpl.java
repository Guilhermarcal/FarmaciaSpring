package com.cotemig.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.springBoot.model.Funcionario;
import com.cotemig.springBoot.repository.FuncionarioRepository;

@Service("funcionarioService")
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Override
	public Optional<Funcionario> getFuncionarioById(Integer id) {
		return funcionarioRepository.findById(id);
	}

	@Override
	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	@Override
	public void deleteAllFuncionarios() {
		funcionarioRepository.deleteAll();
	}

	@Override
	public void deleteFuncionarioById(Integer id) {
		funcionarioRepository.deleteById(id);
	}

	@Override
	public void updateFuncionarioById(Integer id, Funcionario funcionario) {
		Optional<Funcionario> getFuncionario = getFuncionarioById(id);
		getFuncionario.get().setName(funcionario.getName());
		getFuncionario.get().setMatricula(funcionario.getMatricula());
		getFuncionario.get().setCargo(funcionario.getCargo());
		
		funcionarioRepository.save(funcionario);
	}

	@Override
	public void updateFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	@Override
	public void insertFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}	
	
	@Override
	public String getNomeFuncionario(Integer id) {
		return funcionarioRepository.getNomeFuncionario(id);
	}
	
}