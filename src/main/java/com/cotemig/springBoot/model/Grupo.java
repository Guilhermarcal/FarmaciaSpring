package com.cotemig.springBoot.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Grupo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private Boolean checked;
 
	public Grupo(){
 
	}
 
	public Grupo(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	public Grupo(Integer id,String descricao) {
		super();
		this.id = id;	
		this.descricao = descricao;
	}
 
	public Integer getCodigo() {
		return id;
	}
	public void setCodigo(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getChecked() {
		return checked;
	}
 
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
}
