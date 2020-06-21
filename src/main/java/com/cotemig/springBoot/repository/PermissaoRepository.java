package com.cotemig.springBoot.repository;

import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.cotemig.springBoot.entity.GrupoEntity;
import com.cotemig.springBoot.entity.PermissaoEntity;
 
 
public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {
	List<PermissaoEntity> findByGrupos(GrupoEntity grupoEntity);
}
