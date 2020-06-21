package com.cotemig.springBoot.model;

import java.util.List;

public class Usuario {
	 
	private Integer id;
 
	private String nome;
 
	private String login;
 
	private String senha;
 
	private boolean ativo;
 
	private  List<Long> grupos; 
 
	public Usuario(){
 
	}
 
	public Usuario(Integer id, String nome, String login, String senha, boolean ativo, List<Long> grupos) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.ativo = ativo;
		this.grupos = grupos;
	}	
 
	public Integer getId() {		
		return id;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}
 
	public String getNome() {
		return nome;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}
 
	public String getLogin() {
		return login;
	}
 
	public void setLogin(String login) {
		this.login = login;
	}
 
	public String getSenha() {
		return senha;
	}
 
	public void setSenha(String senha) {
		this.senha = senha;
	}
 
	public boolean isAtivo() {
		return ativo;
	}
 
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
 
	public List<Long> getGrupos() {
		return grupos;
	}
 
	public void setGrupos(List<Long> grupos) {
		this.grupos = grupos;
	}
 
}
