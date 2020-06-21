package com.cotemig.springBoot.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Venda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer quantidade;
	
	private String data_venda;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="funcionario_id", updatable=false, insertable=false)
    private Funcionario funcionarios;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="cliente_id", updatable=false, insertable=false)
    private Cliente clientes;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="produto_id", updatable=false, insertable=false)
    private Produto produtos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getData_venda() {
		return data_venda;
	}

	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
	}

	public Funcionario getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}
	
}