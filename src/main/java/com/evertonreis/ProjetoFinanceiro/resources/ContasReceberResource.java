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
	
	@PostMapping
	public ResponseEntity<ContasReceber> insert(@RequestBody ContasReceber obj){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getUsuario()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ContasReceber> delete(@PathVariable Long codigo){
		service.delete(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ContasReceber> update(@PathVariable Long codigo, @RequestBody ContasReceber obj){
		service.update(obj, codigo);
		return ResponseEntity.ok().body(obj);
	}
}
