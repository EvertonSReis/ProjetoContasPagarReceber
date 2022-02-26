package com.evertonreis.ProjetoFinanceiro.resources;

import java.net.URI;
import java.util.List;

import com.evertonreis.ProjetoFinanceiro.repositories.UsuarioRepository;
import com.evertonreis.ProjetoFinanceiro.services.dto.RetornoValidacaoDto;
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

import com.evertonreis.ProjetoFinanceiro.entities.Usuario;
import com.evertonreis.ProjetoFinanceiro.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value ="/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id,@RequestBody Usuario obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping("/logar")
	public ResponseEntity<RetornoValidacaoDto> acesso(@RequestBody Usuario usuario){
		boolean autenticado = this.service.autenticacao(usuario);
		if(!autenticado) throw new RuntimeException("Login ou senha invalido");
		return ResponseEntity.ok().body(new RetornoValidacaoDto(autenticado));
	}
// Posha SAnaca ai tu me quebra kkk, kd o request Body??
}
