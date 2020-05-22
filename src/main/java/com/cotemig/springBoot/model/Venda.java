package com.cotemig.springBoot.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Venda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Double valor_total;
	
	@OneToMany(mappedBy="venda")
    private Set<Funcionario> funcionarios;
	
	@OneToMany(mappedBy="venda")
    private Set<Cliente> clientes;
	
	@OneToMany(mappedBy="venda")
    private Set<Itemvenda> itens;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Set<Itemvenda> getItens() {
		return itens;
	}

	public void setItens(Set<Itemvenda> itens) {
		this.itens = itens;
	}
	
}