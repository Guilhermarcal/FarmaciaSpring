package com.cotemig.springBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cotemig.springBoot.entity.GrupoEntity;
import com.cotemig.springBoot.model.Grupo;
import com.cotemig.springBoot.repository.GrupoRepository;

public class GrupoServiceImpl implements GrupoService {
	@Autowired
	private GrupoRepository grupoRepository;
 
	/**CONSULA OS GRUPOS CADASTRADOS*/
	@Transactional(readOnly = true)
	public List<Grupo> consultarGrupos(){
 
		List<Grupo> grupos =  new ArrayList<Grupo>();
 
		/*CONSULTA TODOS OS GRUPOS*/
		List<GrupoEntity> gruposEntity = this.grupoRepository.findAll();
 
	    gruposEntity.forEach(grupo ->{ 
	    	grupos.add(new Grupo(grupo.getCodigo(), grupo.getDescricao())); 
	    });
 
		return grupos;
	}
}
