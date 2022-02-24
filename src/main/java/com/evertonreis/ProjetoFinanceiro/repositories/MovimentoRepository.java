package com.evertonreis.ProjetoFinanceiro.repositories;

import com.evertonreis.ProjetoFinanceiro.entities.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
}
