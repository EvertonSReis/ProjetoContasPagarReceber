package com.evertonreis.ProjetoFinanceiro.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evertonreis.ProjetoFinanceiro.entities.Usuario;
import com.evertonreis.ProjetoFinanceiro.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	private ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value ="/{id}")
	private ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
