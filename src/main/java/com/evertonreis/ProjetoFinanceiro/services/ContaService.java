package com.evertonreis.ProjetoFinanceiro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertonreis.ProjetoFinanceiro.entities.Conta;
import com.evertonreis.ProjetoFinanceiro.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	
	public List<Conta> findAll(){
		return contaRepository.findAll();
	}
	

	public Conta findById(Long id) {
		Optional<Conta> obj = contaRepository.findById(id);
		return obj.get();
	}
	
	public Conta insert(Conta obj) {
		return contaRepository.save(obj);
	}
	
	public void delete(Long id) {
		contaRepository.deleteById(id);
	}
	
	public Conta update(Long id, Conta obj) {
		Conta entity = contaRepository.getById(id);
		updateData(entity, obj);
		return contaRepository.save(entity);
	}


	private void updateData(Conta entity, Conta obj) {
//		entity.setMovimento(obj.getMovimento());
		entity.setUsuario(obj.getUsuario());
	}
}
