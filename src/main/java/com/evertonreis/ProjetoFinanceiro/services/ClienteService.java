package com.evertonreis.ProjetoFinanceiro.services;

import com.evertonreis.ProjetoFinanceiro.entities.Cliente;
import com.evertonreis.ProjetoFinanceiro.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll(){return repository.findAll();}

    public Cliente findById(Long id){
        Optional<Cliente> list = repository.findById(id);
        return list.get();
    }

    public List<Cliente> findByPartName(String nome){
        return repository.buscarPorParteDoNome(nome);
    }

    public Cliente insert(Cliente obj){return repository.save(obj);}

    public void delete(Long id){repository.deleteById(id);}

    public Cliente update(Long id, Cliente obj){
        Cliente entity = repository.getById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(Cliente entity, Cliente obj) {
        entity.setNomeCliente(obj.getNomeCliente());
        entity.setMovimento(obj.getMovimento());
    }
}
