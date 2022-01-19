package com.evertonreis.ProjetoFinanceiro.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evertonreis.ProjetoFinanceiro.entities.Conta;
import com.evertonreis.ProjetoFinanceiro.services.ContaService;

@RequestMapping
public class ContaResource {
	
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<Conta> findById(@PathVariable Long id){
		Conta obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
