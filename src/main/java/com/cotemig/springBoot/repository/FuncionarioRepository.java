package com.cotemig.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cotemig.springBoot.model.Funcionario;

@Repository("funcionarioRepository")
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	@Query(value = "SELECT nome FROM FUNCIONARIO WHERE id = ?1", nativeQuery = true)
	String getNomeFuncionario(Integer id);
	
}
