package com.evertonreis.ProjetoFinanceiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.evertonreis.ProjetoFinanceiro.entities.Conta;
import com.evertonreis.ProjetoFinanceiro.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping
	public List<Conta> findAll(){
		return contaRepository.findAll();
	}
	
	@GetMapping
	public Conta findById(Long id) {
		Optional<Conta> obj = contaRepository.findById(id);
		return obj.get();
	}
	
}
