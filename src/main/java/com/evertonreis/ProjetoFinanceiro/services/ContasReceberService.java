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
	
	public ContasReceber findById(Long id) {
		Optional<ContasReceber> obj = repository.findById(id);
		return obj.get();
	}
	
	public ContasReceber insert(ContasReceber obj) {
		return repository.save(obj);
	}
	
	public void delete(Long codigo) {
		repository.deleteById(codigo);
	}
	
	public ContasReceber update(ContasReceber obj, Long id) {
		ContasReceber entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(ContasReceber entity, ContasReceber obj) {
		entity.setDataEmissao(obj.getDataEmissao());
		entity.setDataRecebimento(obj.getDataRecebimento());
		entity.setValorReceber(obj.getValorReceber());
	}
	
	
}
