package com.evertonreis.ProjetoFinanceiro.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.evertonreis.ProjetoFinanceiro.entities.pk.ContasPK;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_contasReceber")
public class ContasReceber implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ContasPK codigo = new ContasPK();
	
	private String descricao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataEmissao;
	private Instant dataRecebimento;
	private Double valorReceber;
	
	public ContasReceber() {
	}

	public ContasReceber(Usuario usuario, Conta conta, String descricao, Instant dataEmissao, Instant dataRecebimento, Double valorReceber) {
		super();
		codigo.setUsuario(usuario);
		codigo.setConta(conta);
		this.descricao = descricao;
		this.dataEmissao = dataEmissao;
		this.dataRecebimento = dataRecebimento;
		this.valorReceber = valorReceber;
	}

	public Usuario getUsuario() {
		return codigo.getUsuario();
	}

	public void setUsuario(Usuario usuario) {
		this.codigo.setUsuario(usuario);
	}
	
	public Conta getConta() {
		return codigo.getConta();
	}
	
	public void setConta(Conta conta) {
		this.codigo.setConta(conta);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instant getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Instant dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Instant getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Instant dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Double getValorReceber() {
		return valorReceber;
	}

	public void setValorReceber(Double valorReceber) {
		this.valorReceber = valorReceber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContasReceber other = (ContasReceber) obj;
		return Objects.equals(codigo, other.codigo);
	}
}
