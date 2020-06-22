package com.cotemig.springBoot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="permissao", schema="farmacia")
@Entity
public class PermissaoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_permissao")	
	private Integer codigo;
 
	@Column(name="permissao")	
	private String permissao;
 
	@Column(name="descricao")	
	private String descricao;	
 
	@ManyToMany(mappedBy = "permissoes")
	private List<GrupoEntity> grupos;
 
	public Integer getCodigo() {
		return codigo;
	}
 
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
 
	public String getPermissao() {
		return permissao;
	}
 
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
 
	public String getDescricao() {
		return descricao;
	}
 
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
 
	public List<GrupoEntity> getGrupos() {
		return grupos;
	}
 
	public void setGrupos(List<GrupoEntity> grupos) {
		this.grupos = grupos;
	}
}
