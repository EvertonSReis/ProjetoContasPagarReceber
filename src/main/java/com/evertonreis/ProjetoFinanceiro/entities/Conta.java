package com.evertonreis.ProjetoFinanceiro.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_conta")
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titular;
	private Double saldo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario clientes;
	
	@OneToMany
	private Set<ContasReceber> contasReceber = new HashSet<>();
	
	public Conta() {
	}

	public Conta(Long id, String titular, Double saldo, Usuario clientes) {
		super();
		this.id = id;
		this.titular = titular;
		this.saldo = saldo;
		this.clientes = clientes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Usuario getClientes() {
		return clientes;
	}
	
	public void setClientes(Usuario clientes) {
		this.clientes = clientes;
	}
	
	public Set<ContasReceber> getContasReceber(){
		return contasReceber;
	}
	
	public void setContasReceber(Set<ContasReceber> contasReceber) {
		this.contasReceber = contasReceber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
