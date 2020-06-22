package com.cotemig.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import com.cotemig.springBoot.entity.GrupoEntity;
 
@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity, Long>{
	
	@Query(value = "SELECT id_grupo FROM usuario_grupo WHERE id_usuario = ?1", nativeQuery = true)
	Integer findByUsuarios(Integer id);
 
}