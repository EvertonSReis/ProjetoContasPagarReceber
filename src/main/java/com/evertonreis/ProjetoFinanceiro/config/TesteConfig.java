package com.evertonreis.ProjetoFinanceiro.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.evertonreis.ProjetoFinanceiro.entities.Conta;
import com.evertonreis.ProjetoFinanceiro.entities.Usuario;
import com.evertonreis.ProjetoFinanceiro.repositories.ContaRepository;
import com.evertonreis.ProjetoFinanceiro.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ContaRepository contaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario user = new Usuario(null, "Everton Reis", "everton", "123456");
		Conta cont = new Conta(null, "Everton Reis", 2000.00, user);
		
		usuarioRepository.saveAll(Arrays.asList(user));
		contaRepository.saveAll(Arrays.asList(cont));
		
		
	}	
	
	

}
