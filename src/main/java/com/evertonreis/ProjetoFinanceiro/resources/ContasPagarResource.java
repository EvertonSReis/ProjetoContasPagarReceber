package com.evertonreis.ProjetoFinanceiro.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<ContasPagar> insert(@RequestBody ContasPagar obj){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ContasPagar> delete(@PathVariable Long codigo){
		service.delete(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ContasPagar> update(@PathVariable Long codigo, @RequestBody ContasPagar obj){
		obj = service.update(codigo, obj);
		return ResponseEntity.ok().body(obj);
	}
}
