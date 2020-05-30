package com.cotemig.springBoot.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.springBoot.model.Funcionario;

public interface FuncionarioService {
	Optional<Funcionario> getFuncionarioById(Integer id);
	List<Funcionario> getAllFuncionario();
	void deleteAllFuncionarios();
	void deleteFuncionarioById(Integer id);
	void updateFuncionarioById(Integer id, Funcionario funcionario);
	void updateFuncionario(Funcionario funcionario);
	void insertFuncionario(Funcionario funcionario);
	String getNomeFuncionario(Integer id);
}