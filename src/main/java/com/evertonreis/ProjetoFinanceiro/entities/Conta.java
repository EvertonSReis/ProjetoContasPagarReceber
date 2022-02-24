package com.evertonreis.ProjetoFinanceiro.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_conta")
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
//	@ManyToMany
//	@JoinColumn(name = "id_movimento")
//	private Movimento movimento;

}
