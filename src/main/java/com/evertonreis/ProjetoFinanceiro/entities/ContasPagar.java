package com.evertonreis.ProjetoFinanceiro.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.evertonreis.ProjetoFinanceiro.entities.enums.FormaDePagamento;
import com.evertonreis.ProjetoFinanceiro.entities.pk.ContasPK;

@Entity
@Table(name = "tb_contasPagar")
public class ContasPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContasPK codigo = new ContasPK();
	
	private Instant dataVenciemnto;
	private Instant dataEmissao;
	private Instant dataPagamento;
	private String descricao;
	private Double valorPagar;
	
	@Enumerated(EnumType.STRING)
	private FormaDePagamento formaDePagamento;
	
	
	public ContasPagar() {
	}

	public ContasPagar(Usuario usuario, Conta conta, Instant dataVenciemnto, Instant dataEmissao, Instant dataPagamento,
			String descricao, Double valorPagar, FormaDePagamento formaDePagamento) {
		super();
		codigo.setUsuario(usuario);
		codigo.setConta(conta);
		this.dataVenciemnto = dataVenciemnto;
		this.dataEmissao = dataEmissao;
		this.dataPagamento = dataPagamento;
		this.descricao = descricao;
		this.valorPagar = valorPagar;
		this.formaDePagamento = formaDePagamento;
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

	public Instant getDataVenciemnto() {
		return dataVenciemnto;
	}

	public void setDataVenciemnto(Instant dataVenciemnto) {
		this.dataVenciemnto = dataVenciemnto;
	}

	public Instant getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Instant dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Instant getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Instant dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(Double valorpagar) {
		this.valorPagar = valorpagar;
	}
	
	public FormaDePagamento getValor() {
		return formaDePagamento;
	}

	public void setValor(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
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
		ContasPagar other = (ContasPagar) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
}
