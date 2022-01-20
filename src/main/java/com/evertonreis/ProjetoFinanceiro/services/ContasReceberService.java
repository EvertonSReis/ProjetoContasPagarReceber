package com.evertonreis.ProjetoFinanceiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertonreis.ProjetoFinanceiro.entities.ContasReceber;
import com.evertonreis.ProjetoFinanceiro.repositories.ContasReceberRepository;

@Service
public class ContasReceberService {

	@Autowired
	private ContasReceberRepository repository;
	
	public List<ContasReceber> findAll() {
		return repository.findAll();
	}
	
	public ContasReceber findById(Long codigo) {
		Optional<ContasReceber> obj = repository.findById(codigo);
		return obj.get();
	}
	
}
