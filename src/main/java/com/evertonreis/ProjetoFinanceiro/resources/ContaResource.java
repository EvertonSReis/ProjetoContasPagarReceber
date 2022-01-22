package com.evertonreis.ProjetoFinanceiro.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evertonreis.ProjetoFinanceiro.entities.Conta;
import com.evertonreis.ProjetoFinanceiro.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> findById(@PathVariable Long id){
		Conta obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}