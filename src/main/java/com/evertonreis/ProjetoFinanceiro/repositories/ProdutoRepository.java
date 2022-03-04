package com.evertonreis.ProjetoFinanceiro.repositories;

import com.evertonreis.ProjetoFinanceiro.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query(value = "Select * from tb_produto p where p.nome_produto ilike %:nome%", nativeQuery = true)
    List<Produto> buscarPorParteDoNome(String nome);
}
