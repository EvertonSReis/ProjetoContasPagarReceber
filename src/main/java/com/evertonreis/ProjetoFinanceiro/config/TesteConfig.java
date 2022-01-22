package com.evertonreis.ProjetoFinanceiro.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.evertonreis.ProjetoFinanceiro.entities.Conta;
import com.evertonreis.ProjetoFinanceiro.entities.ContasPagar;
import com.evertonreis.ProjetoFinanceiro.entities.ContasReceber;
import com.evertonreis.ProjetoFinanceiro.entities.Usuario;
import com.evertonreis.ProjetoFinanceiro.repositories.ContaRepository;
import com.evertonreis.ProjetoFinanceiro.repositories.ContasPagarRepository;
import com.evertonreis.ProjetoFinanceiro.repositories.ContasReceberRepository;
import com.evertonreis.ProjetoFinanceiro.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ContasReceberRepository contasReceberRepository;
	
	@Autowired
	private ContasPagarRepository contasPagarRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario user = new Usuario(null, "Everton Reis", "everton", "123456");
		Usuario user1 = new Usuario(null, "Loize Matos", "loize", "123648");
		Usuario user2 = new Usuario(null, "Lorenzo Matos", "lorenzo", "134628");
		Conta cont = new Conta(null, user.getNome(), 2000.00, user);
		Conta cont1 = new Conta(null, user1.getNome(), 2500.00, user1);
		Conta cont2 = new Conta(null, user2.getNome(), 1500.00, user2);
		
		usuarioRepository.saveAll(Arrays.asList(user, user1, user2));
		contaRepository.saveAll(Arrays.asList(cont, cont1, cont2));
		
		ContasReceber cr = new ContasReceber(user, cont, "Pagamento teste", null, null, 150.00);
		ContasPagar cp = new ContasPagar(user, cont, null, null, null, "test", 80.00);
		
		contasReceberRepository.saveAll(Arrays.asList(cr));
		contasPagarRepository.saveAll(Arrays.asList(cp));
		
		
		
	}	
	
	

}
