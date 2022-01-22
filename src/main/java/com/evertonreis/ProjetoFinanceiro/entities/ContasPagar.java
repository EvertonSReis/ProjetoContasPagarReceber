package com.evertonreis.ProjetoFinanceiro.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.evertonreis.ProjetoFinanceiro.entities.pk.ContasPK;

@Entity
@Table(name = "tb_contasPagar")
public class ContasPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContasPK codigo = new ContasPK();
	
	private Date dataVenciemnto;
	private Date dataEmissao;
	private Date dataPagamento;
	private String descricao;
	private Double valor;
	
	public ContasPagar() {
	}

	public ContasPagar(Usuario usuario, Conta conta, Date dataVenciemnto, Date dataEmissao, Date dataPagamento,
			String descricao, Double valor) {
		super();
		codigo.setUsuario(usuario);
		codigo.setConta(conta);
		this.dataVenciemnto = dataVenciemnto;
		this.dataEmissao = dataEmissao;
		this.dataPagamento = dataPagamento;
		this.descricao = descricao;
		this.valor = valor;
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

	public Date getDataVenciemnto() {
		return dataVenciemnto;
	}

	public void setDataVenciemnto(Date dataVenciemnto) {
		this.dataVenciemnto = dataVenciemnto;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
