package com.evertonreis.ProjetoFinanceiro.repositories;

import com.evertonreis.ProjetoFinanceiro.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
