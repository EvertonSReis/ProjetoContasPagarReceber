package com.evertonreis.ProjetoFinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evertonreis.ProjetoFinanceiro.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
