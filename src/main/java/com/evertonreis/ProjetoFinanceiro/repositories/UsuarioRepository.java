package com.evertonreis.ProjetoFinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evertonreis.ProjetoFinanceiro.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
