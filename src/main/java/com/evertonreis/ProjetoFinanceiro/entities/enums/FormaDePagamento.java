package com.evertonreis.ProjetoFinanceiro.entities.enums;

public enum FormaDePagamento {
	
	DINHEIRO(1),
	DEBITO(2),
	CREDITO(3),
	CHEQUE(4),
	BOLETO(5);
	
	private Integer valor;

	FormaDePagamento(Integer valor) {
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}

}
