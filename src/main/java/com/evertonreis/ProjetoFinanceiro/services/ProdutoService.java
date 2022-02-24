package com.evertonreis.ProjetoFinanceiro.services;

import com.evertonreis.ProjetoFinanceiro.entities.Cliente;
import com.evertonreis.ProjetoFinanceiro.entities.Produto;
import com.evertonreis.ProjetoFinanceiro.repositories.ClienteRepository;
import com.evertonreis.ProjetoFinanceiro.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){return repository.findAll();}

    public Produto findById(Long id){
        Optional<Produto> list = repository.findById(id);
        return list.get();
    }

    public Produto insert(Produto obj){return repository.save(obj);}

    public void delete(Long id){repository.deleteById(id);}

    public Produto update(Long id, Produto obj){
        Produto entity = repository.getById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(Produto entity, Produto obj) {
        entity.setId(obj.getId());
        entity.setNomeProduto(obj.getNomeProduto());
        entity.setEstoque(obj.getEstoque());
        entity.setValorProduto(obj.getValorProduto());
    }
}
