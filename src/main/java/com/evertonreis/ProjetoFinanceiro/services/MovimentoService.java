package com.evertonreis.ProjetoFinanceiro.services;

import com.evertonreis.ProjetoFinanceiro.entities.Movimento;
import com.evertonreis.ProjetoFinanceiro.entities.Produto;
import com.evertonreis.ProjetoFinanceiro.repositories.MovimentoRepository;
import com.evertonreis.ProjetoFinanceiro.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentoService {

    @Autowired
    private MovimentoRepository repository;

    public List<Movimento> findAll(){return repository.findAll();}

    public Movimento findById(Long id){
        Optional<Movimento> list = repository.findById(id);
        return list.get();
    }

    public Movimento insert(Movimento obj){return repository.save(obj);}

    public void delete(Long id){repository.deleteById(id);}

    public Movimento update(Long id, Movimento obj){
        Movimento entity = repository.getById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(Movimento entity, Movimento obj) {
        entity.setId(obj.getId());
        entity.setDataVenda(obj.getDataVenda());
        entity.setClientes(obj.getClientes());
        entity.setProdutos(obj.getProdutos());
        entity.setQuantidadeProduto(obj.getQuantidadeProduto());
    }
}
