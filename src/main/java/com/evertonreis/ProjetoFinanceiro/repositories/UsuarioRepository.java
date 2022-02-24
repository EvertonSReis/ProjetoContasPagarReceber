package com.evertonreis.ProjetoFinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evertonreis.ProjetoFinanceiro.entities.Usuario;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//
//    @Query(value = "select CASE WHEN cont[1] > 0 THEN 'true' ELSE 'false' END from tb_usuario where id =:id", nativeQuery = true)
//    public boolean exist(int id);

    //Ultima tentatica
    @Query(value = "select * from tb_usuario where login = :login and senha = :senha", nativeQuery = true)

     Usuario loginUser(String login, String senha);

}