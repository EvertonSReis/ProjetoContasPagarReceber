package com.evertonreis.ProjetoFinanceiro.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import com.evertonreis.ProjetoFinanceiro.entities.*;
import com.evertonreis.ProjetoFinanceiro.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.evertonreis.ProjetoFinanceiro.entities.enums.FormaDePagamento;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private MovimentoRepository movimentoRepository;

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ContasReceberRepository contasReceberRepository;

	@Autowired
	private ContasPagarRepository contasPagarRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {

		Usuario user = new Usuario(null, "Everton Reis", "Everton", "123456");
		Usuario user1 = new Usuario(null, "Loize Matos", "loize", "123648");
		Usuario user2 = new Usuario(null, "Lorenzo Matos", "lorenzo", "134628");
		Usuario user3 = new Usuario(null, "teste", "1", "1");
//		Conta cont = new Conta(null, user.getNome(), 2000.00, user);
//		Conta cont1 = new Conta(null, user1.getNome(), 2500.00, user1);
//		Conta cont2 = new Conta(null, user2.getNome(), 1500.00, user2);
		usuarioRepository.saveAll(Arrays.asList(user, user1, user2, user3));

		Cliente cliente = new Cliente(null, "Jhonathan Martins", null);
		Cliente cliente1 = new Cliente(null, "Everton Reis", null);
		Cliente cliente2 = new Cliente(null, "Fulano 01", null);
		Cliente cliente3 = new Cliente(null, "Fulano 02", null);
		Cliente cliente4 = new Cliente(null, "Fulano 03", null);
		clienteRepository.saveAll(Arrays.asList(cliente, cliente1, cliente2, cliente3, cliente4));

		Produto produto = new Produto(null, "Produto 01", 50.00, 100, null);
		Produto produto1 = new Produto(null, "Produto 02", 40.00, 50, null);
		Produto produto2 = new Produto(null, "Produto 03", 30.00, 40, null);
		Produto produto3 = new Produto(null, "Produto 04", 20.00, 150, null);
		Produto produto4 = new Produto(null, "Produto 05", 10.00, 700, null);
		produtoRepository.saveAll(Arrays.asList(produto, produto1, produto2, produto3, produto4));

		Movimento movimento = new Movimento(null, 10.00, LocalDate.of(2020, 02,01), Arrays.asList(produto, produto1, produto2, produto3, produto4), cliente);
		Movimento movimento1 = new Movimento(null, 2.00, LocalDate.of(2020, 02,01), Arrays.asList(produto, produto1, produto2, produto3, produto4), cliente1);
		Movimento movimento2 = new Movimento(null, 60.00, LocalDate.of(2020, 02,01), Arrays.asList(produto, produto1, produto2, produto3, produto4), cliente3);
		movimentoRepository.saveAll(Arrays.asList(movimento, movimento1, movimento2));

		ContasReceber cr = new ContasReceber(null, null, LocalDate.of(2022,02,01), LocalDate.of(2022,02,02), 150.00);
		ContasReceber cr1 = new ContasReceber(null, null, null, null, 100.00);
		ContasReceber cr2 = new ContasReceber(null, null, null, null, 50.00);
		contasReceberRepository.saveAll(Arrays.asList(cr, cr1, cr2));

		ContasPagar cp = new ContasPagar(null, LocalDate.of(2022,02,05), LocalDate.of(2022,02,05), LocalDate.of(2022,02,05), "teste novo", 100.00, FormaDePagamento.DINHEIRO);
		ContasPagar cp1 = new ContasPagar(null, LocalDate.of(2022,02,05), LocalDate.of(2022,02,05), LocalDate.of(2022,02,05), "test", null, FormaDePagamento.CHEQUE);
		ContasPagar cp2 = new ContasPagar(null, LocalDate.of(2022,02,05), LocalDate.of(2022,02,05), null, "test", null, FormaDePagamento.BOLETO);
		contasPagarRepository.saveAll(Arrays.asList(cp, cp1,  cp2));

	}
}
