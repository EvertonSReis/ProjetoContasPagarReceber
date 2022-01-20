package com.evertonreis.ProjetoFinanceiro.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.evertonreis.ProjetoFinanceiro.entities.pk.ContasReceberPK;

@Entity
@Table(name = "tb_contasReceber")
public class ContasReceber implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ContasReceberPK codigo = new ContasReceberPK();
	
	private String descricao;
	private Date dataEmissao;
	private Date dataRecebimento;
	private Double valorReceber;
	
	public ContasReceber() {
	}

	public ContasReceber(Usuario usuario, Conta conta, String descricao, Date dataEmissao, Date dataRecebimento, Double valorReceber) {
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

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
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
