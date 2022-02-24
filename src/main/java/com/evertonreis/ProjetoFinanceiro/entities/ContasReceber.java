package com.evertonreis.ProjetoFinanceiro.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_contasReceber")
public class ContasReceber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "movimento_id")
	private Movimento movimento;

	private LocalDate dataEmissao = LocalDate.now();
	private LocalDate dataRecebimento = LocalDate.now();
	private Double valorReceber;

}
