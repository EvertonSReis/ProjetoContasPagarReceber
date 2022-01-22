package com.evertonreis.ProjetoFinanceiro.config;

import java.time.Instant;
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
		
		ContasReceber cr = new ContasReceber(user, cont, "Pagamento teste", Instant.parse("2022-01-22T00:00:00Z"), null, 150.00);
		ContasReceber cr1 = new ContasReceber(user1, cont1, "Pagamento teste", Instant.parse("2022-01-20T00:00:00Z"), Instant.parse("2022-01-21T00:00:00Z"), 100.00);
		ContasReceber cr2 = new ContasReceber(user2, cont2, "Pagamento teste", Instant.parse("2022-01-21T00:00:00Z"), Instant.parse("2022-01-23T00:00:00Z"), 50.00);

		ContasPagar cp = new ContasPagar(user, cont, Instant.parse("2022-01-23T00:00:00Z"), Instant.parse("2022-01-28T00:00:00Z"), null, "test", 80.00);
		ContasPagar cp1 = new ContasPagar(user1, cont1, Instant.parse("2022-01-28T00:00:00Z"), Instant.parse("2022-01-30T00:00:00Z"), Instant.parse("2022-01-30T00:00:00Z"), "test", 80.00);
		ContasPagar cp2 = new ContasPagar(user2, cont2, Instant.parse("2022-02-01T00:00:00Z"), Instant.parse("2022-02-02T00:00:00Z"), null, "test", 80.00);
		
		contasReceberRepository.saveAll(Arrays.asList(cr, cr1, cr2));
		contasPagarRepository.saveAll(Arrays.asList(cp, cp1,  cp2));
		
		
		
	}	
	
	

}
