package com.cotemig.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cotemig.springBoot.entity.PermissaoEntity;
 
 
public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {
	
	@Query(value = "SELECT id_permissao FROM permissao_grupo WHERE id_grupo = ?1", nativeQuery = true)
	Integer findByGrupos(Integer id_grupo);
}
