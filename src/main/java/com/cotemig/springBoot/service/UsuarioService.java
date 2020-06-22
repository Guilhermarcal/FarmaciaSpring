package com.cotemig.springBoot.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cotemig.springBoot.entity.GrupoEntity;
import com.cotemig.springBoot.entity.UsuarioEntity;

public interface UsuarioService {
	
	UserDetails loadUserByUsername(String login);
	List<GrantedAuthority> buscarPermissoesUsuario(UsuarioEntity usuarioEntity);
	List<GrantedAuthority> buscarPermissoesDosGrupos(GrupoEntity grupoUsuario);
	
}