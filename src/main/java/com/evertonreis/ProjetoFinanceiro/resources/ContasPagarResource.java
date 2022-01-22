package com.evertonreis.ProjetoFinanceiro.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evertonreis.ProjetoFinanceiro.entities.ContasPagar;
import com.evertonreis.ProjetoFinanceiro.services.ContasPagarService;

@RestController
@RequestMapping(value = "/pagar")
public class ContasPagarResource {
	
	@Autowired
	private ContasPagarService service;
	
	@GetMapping
	public ResponseEntity<List<ContasPagar>> findAll(){
		List<ContasPagar> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContasPagar> findById(@PathVariable Long id){
		ContasPagar obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
