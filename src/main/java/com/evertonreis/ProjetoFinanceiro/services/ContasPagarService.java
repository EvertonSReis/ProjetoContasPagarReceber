package com.evertonreis.ProjetoFinanceiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertonreis.ProjetoFinanceiro.entities.ContasPagar;
import com.evertonreis.ProjetoFinanceiro.repositories.ContasPagarRepository;

@Service
public class ContasPagarService {
	
	@Autowired
	private ContasPagarRepository repository;
	
	public List<ContasPagar> findAll(){
		return repository.findAll();
	}
	
	public ContasPagar findById(Long codigo) {
		Optional<ContasPagar> obj = repository.findById(codigo);
		return obj.get();
	}

}
