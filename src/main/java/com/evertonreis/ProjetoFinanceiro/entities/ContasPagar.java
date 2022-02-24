package com.evertonreis.ProjetoFinanceiro.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.evertonreis.ProjetoFinanceiro.entities.enums.FormaDePagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_contasPagar")
public class ContasPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private LocalDate dataVenciemnto;
	private LocalDate dataEmissao;
	private LocalDate dataPagamento;
	private String descricao;
	private Double valorPagar;
	
	@Enumerated(EnumType.STRING)
	private FormaDePagamento formaDePagamento;

}
