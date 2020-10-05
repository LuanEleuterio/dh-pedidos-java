package br.com.dh.desafiovespertino.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pedido {

	@Id
	private Integer nfe;
	private String status_pedido;
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_cliente")
	@JsonIgnoreProperties("pedidos")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_funcionario")
	private Funcionario funcionario;

	public Pedido() {}
	
	public Pedido(Integer nfe, String status_pedido,Integer quantidade,Integer fk_id_cliente, Integer fk_id_funcionario) {
		this.nfe = nfe;
		this.status_pedido = status_pedido;
		this.quantidade = quantidade;
		//this.fk_id_cliente = fk_id_cliente;
		//this.fk_id_funcionario = fk_id_funcionario;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	/*
	public Integer getFk_id_cliente() {
		return fk_id_cliente;
	}

	public void setFk_id_cliente(Integer fk_id_cliente) {
		this.fk_id_cliente = fk_id_cliente;
	}

	public Integer getFk_id_funcionario() {
		return fk_id_funcionario;
	}

	public void setFk_id_funcionario(Integer fk_id_funcionario) {
		this.fk_id_funcionario = fk_id_funcionario;
	}
	 */
	public Integer getNfe() {
		return nfe;
	}
	public void setNfe(int nfe) {
		this.nfe = nfe;
	}
	public String getStatus_pedido() {
		return status_pedido;
	}
	public void setStatus_pedido(String status_pedido) {
		this.status_pedido = status_pedido;
	}
	
	
}
