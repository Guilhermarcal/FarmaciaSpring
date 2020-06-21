package com.cotemig.springBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.cotemig.springBoot.entity.GrupoEntity;
import com.cotemig.springBoot.entity.UsuarioEntity;
 
@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity, Long>{
	
	List<GrupoEntity> findByUsuarios(UsuarioEntity usuarioEntity);
 
}