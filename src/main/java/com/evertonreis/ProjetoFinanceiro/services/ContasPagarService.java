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
	
	public ContasPagar insert(ContasPagar obj) {
		return repository.save(obj);
	}
	
	public void delete(Long codigo) {
		repository.deleteById(codigo);
	}
	
	public ContasPagar update(Long codigo, ContasPagar obj) {
		ContasPagar entity = repository.getById(codigo);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(ContasPagar entity, ContasPagar obj) {
		entity.setDataEmissao(obj.getDataEmissao());
		entity.setDataPagamento(obj.getDataPagamento());
		entity.setDataVenciemnto(obj.getDataVenciemnto());
		entity.setDescricao(obj.getDescricao());
		entity.setValor(obj.getValor());
	}

}
