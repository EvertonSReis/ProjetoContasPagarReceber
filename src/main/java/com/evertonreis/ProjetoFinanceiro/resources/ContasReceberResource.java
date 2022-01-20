package com.evertonreis.ProjetoFinanceiro.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evertonreis.ProjetoFinanceiro.entities.ContasReceber;
import com.evertonreis.ProjetoFinanceiro.services.ContasReceberService;

@RestController
@RequestMapping(value = "/receber")
public class ContasReceberResource {
	
	@Autowired
	private ContasReceberService service;
	
	@GetMapping
	public ResponseEntity<List<ContasReceber>> findAll(){
		List<ContasReceber> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContasReceber> findById(@PathVariable Long codigo){
		ContasReceber obj = service.findById(codigo);
		return ResponseEntity.ok().body(obj);
	}
}
