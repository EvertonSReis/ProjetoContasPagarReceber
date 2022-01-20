package com.evertonreis.ProjetoFinanceiro.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.evertonreis.ProjetoFinanceiro.entities.Conta;
import com.evertonreis.ProjetoFinanceiro.entities.Usuario;

@Embeddable
public class ContasReceberPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Conta conta;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conta, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContasReceberPK other = (ContasReceberPK) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(usuario, other.usuario);
	}
	
	
}
