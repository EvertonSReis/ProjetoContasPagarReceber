package com.evertonreis.ProjetoFinanceiro.resources;

import com.evertonreis.ProjetoFinanceiro.entities.Cliente;
import com.evertonreis.ProjetoFinanceiro.entities.Movimento;
import com.evertonreis.ProjetoFinanceiro.entities.Produto;
import com.evertonreis.ProjetoFinanceiro.services.MovimentoService;
import com.evertonreis.ProjetoFinanceiro.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/movimentos")
public class MovimentoRessource {

    @Autowired
    private MovimentoService service;

    @GetMapping
    public ResponseEntity<List<Movimento>> findAll(){
        List<Movimento> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movimento> findById(@PathVariable Long id){
        Movimento obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/pesquisa")
    public  ResponseEntity<List<Movimento>> findByPartName(@PathParam("nome") String nome){
        return ResponseEntity.ok().body(service.findByPartName(nome));
    }

    @PostMapping
    public ResponseEntity<Movimento> insert(@RequestBody Movimento obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Movimento>  delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Movimento> update(@PathVariable Long id, @RequestBody Movimento obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
