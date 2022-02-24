package com.evertonreis.ProjetoFinanceiro.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.evertonreis.ProjetoFinanceiro.entities.Conta;
import com.evertonreis.ProjetoFinanceiro.entities.ContasPagar;
import com.evertonreis.ProjetoFinanceiro.entities.ContasReceber;
import com.evertonreis.ProjetoFinanceiro.entities.Usuario;
import com.evertonreis.ProjetoFinanceiro.entities.enums.FormaDePagamento;
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

		Usuario user = new Usuario(null, "Everton Reis", "Everton", "123456");
		Usuario user1 = new Usuario(null, "Loize Matos", "loize", "123648");
		Usuario user2 = new Usuario(null, "Lorenzo Matos", "lorenzo", "134628");
//		Conta cont = new Conta(null, user.getNome(), 2000.00, user);
//		Conta cont1 = new Conta(null, user1.getNome(), 2500.00, user1);
//		Conta cont2 = new Conta(null, user2.getNome(), 1500.00, user2);

		usuarioRepository.saveAll(Arrays.asList(user, user1, user2));

		// CRTL + / comenta
//		contaRepository.saveAll(Arrays.asList(cont, cont1, cont2));

		ContasReceber cr = new ContasReceber(null, null, LocalDate.of(2022,02,01), LocalDate.of(2022,02,02), 150.00);
		ContasReceber cr1 = new ContasReceber(null, null, null, null, 100.00);
		ContasReceber cr2 = new ContasReceber(null, null, null, null, 50.00);

		ContasPagar cp = new ContasPagar(null, LocalDate.of(2022,02,05), LocalDate.of(2022,02,05), LocalDate.of(2022,02,05), "teste novo", 100.00, FormaDePagamento.DINHEIRO);
		ContasPagar cp1 = new ContasPagar(null, LocalDate.of(2022,02,05), LocalDate.of(2022,02,05), LocalDate.of(2022,02,05), "test", null, FormaDePagamento.CHEQUE);
		ContasPagar cp2 = new ContasPagar(null, LocalDate.of(2022,02,05), LocalDate.of(2022,02,05), null, "test", null, FormaDePagamento.BOLETO);

		contasReceberRepository.saveAll(Arrays.asList(cr, cr1, cr2));
		contasPagarRepository.saveAll(Arrays.asList(cp, cp1,  cp2));

	}	
}
