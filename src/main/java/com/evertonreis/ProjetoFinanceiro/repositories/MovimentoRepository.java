package com.evertonreis.ProjetoFinanceiro.repositories;

import com.evertonreis.ProjetoFinanceiro.entities.Cliente;
import com.evertonreis.ProjetoFinanceiro.entities.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
    @Query(value = "Select * from tb_movimento m " +
            "inner join tb_cliente c on m.clientes_id = c.id " +
            "where c.nome_cliente ilike %:nome%", nativeQuery = true)
    List<Movimento> buscarPorParteDoNome(String nome);
}
