package com.cotemig.springBoot.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private String matricula;
	
	private String senha;
	
	private Boolean ativo;

	private String cargo;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_id", nullable = false, updatable = false) // Esta coluna está na tabela "venda".
	private Set<Venda> vendas;
	
	public Funcionario(){
		 
	}
 
	public Funcionario(Integer id, String nome, String matricula, String senha, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
		this.ativo = ativo;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Set<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}	
	
}