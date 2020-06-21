package com.cotemig.springBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cotemig.springBoot.entity.GrupoEntity;
import com.cotemig.springBoot.entity.PermissaoEntity;
import com.cotemig.springBoot.entity.UsuarioEntity;
import com.cotemig.springBoot.model.UsuarioSecurityModel;
import com.cotemig.springBoot.repository.GrupoRepository;
import com.cotemig.springBoot.repository.PermissaoRepository;
import com.cotemig.springBoot.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
 
	@Autowired
	private GrupoRepository grupoRepository; 
 
	@Autowired
	private PermissaoRepository permissaoRepository;
 
	/***
	 * CONSULTA UM USUÁRIO POR LOGIN
	 */
	@Override
	public UserDetails loadUserByUsername(String login) throws BadCredentialsException,DisabledException {
 
		UsuarioEntity usuarioEntity = usuarioRepository.findByLogin(login);
 
		if(usuarioEntity == null)
			throw new BadCredentialsException("Usuário não encontrado no sistema!");
 
		if(!usuarioEntity.isAtivo())
			throw new DisabledException("Usuário não está ativo no sistema!");
 
		return new UsuarioSecurityModel(
				usuarioEntity.getLogin(), 
				usuarioEntity.getSenha(), 
				usuarioEntity.isAtivo(), 
				this.buscarPermissoesUsuario(usuarioEntity));
	}
 
	/***
	 * BUSCA AS PERMISSÕES DO USUÁRIO
	 * @param usuarioEntity
	 * @return
	 */
	public List<GrantedAuthority> buscarPermissoesUsuario(UsuarioEntity usuarioEntity) {
 
		List<GrupoEntity> grupos = grupoRepository.findByUsuarios(usuarioEntity);
 
		return this.buscarPermissoesDosGrupos(grupos);
	}
 
	/***
	 * BUSCA AS PERMISSÕES DO GRUPO
	 * */
	public List<GrantedAuthority> buscarPermissoesDosGrupos(List<GrupoEntity> grupos) {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
 
		for (GrupoEntity grupo: grupos) {
 
			List<PermissaoEntity> lista = permissaoRepository.findByGrupos(grupo);
 
			for (PermissaoEntity permissao: lista) {
				auths.add(new SimpleGrantedAuthority(permissao.getPermissao()));
			}
		}
 
		return auths;
	}
 
}
