package com.cotemig.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cotemig.springBoot.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	 
	@Query(value = "SELECT * FROM usuario WHERE login = ?1", nativeQuery = true) 
	UsuarioEntity findByLogin(String login);
 
}
