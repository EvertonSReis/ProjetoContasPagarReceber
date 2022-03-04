package com.evertonreis.ProjetoFinanceiro.repositories;

import com.evertonreis.ProjetoFinanceiro.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "Select * from tb_cliente c where c.nome_cliente ilike %:nome%", nativeQuery = true)
    List<Cliente> buscarPorParteDoNome(String nome);
}
