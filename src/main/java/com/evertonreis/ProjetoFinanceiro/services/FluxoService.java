//package com.evertonreis.ProjetoFinanceiro.services;
//
//import com.evertonreis.ProjetoFinanceiro.entities.Fluxo;
//import com.evertonreis.ProjetoFinanceiro.repositories.FluxoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.Entity;
//import java.io.Serializable;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class FluxoService{
//
//    @Autowired
//    private FluxoRepository repository;
//
//    public List<Fluxo> findAll(){return repository.findAll();}
//
//    public Fluxo findById(Long id){
//        Optional<Fluxo> list = repository.findById(id);
//        return list.get();}
//
//    public Fluxo insert(Fluxo obj){ return repository.save(obj);}
//
//    public void delete(Long id){repository.deleteById(id);}
//
//
//}
