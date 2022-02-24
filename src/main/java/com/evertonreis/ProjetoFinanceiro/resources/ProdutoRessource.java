package com.evertonreis.ProjetoFinanceiro.resources;

import com.evertonreis.ProjetoFinanceiro.entities.Cliente;
import com.evertonreis.ProjetoFinanceiro.entities.Produto;
import com.evertonreis.ProjetoFinanceiro.services.ClienteService;
import com.evertonreis.ProjetoFinanceiro.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRessource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping
    public ResponseEntity<Produto>  delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
