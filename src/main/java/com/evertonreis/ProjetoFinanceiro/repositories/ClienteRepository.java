package com.evertonreis.ProjetoFinanceiro.repositories;

import com.evertonreis.ProjetoFinanceiro.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
