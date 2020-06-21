package com.cotemig.springBoot.entity;

import java.io.Serializable;
import java.util.List;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Table(name="grupo", schema="farmacia")
@Entity
public class GrupoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_grupo")
	private Integer id;
 
	@Column(name="nome")
	private String nome;
 
	@Column(name="descricao")
	private String descricao;
 
	@ManyToMany
	@JoinTable(
	name="USUARIO_GRUPO",
	joinColumns=@JoinColumn(name="id_grupo", referencedColumnName="id_grupo"),
	inverseJoinColumns=@JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
	)
	private List<UsuarioEntity> usuarios;
 
	@ManyToMany
	@JoinTable(
	name="PERMISSAO_GRUPO",
	joinColumns=@JoinColumn(name="id_grupo", referencedColumnName="id_grupo"),
	inverseJoinColumns=@JoinColumn(name="id_permissao", referencedColumnName="id_permissao")
	)
	private List<PermissaoEntity> permissoes;
 
 
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
 
	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}
 
	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}
 
	public List<PermissaoEntity> getPermissoes() {
		return permissoes;
	}
 
	public void setPermissoes(List<PermissaoEntity> permissoes) {
		this.permissoes = permissoes;
	}
 
}
