package com.evertonreis.ProjetoFinanceiro.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_movimento")
public class Movimento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double quantidadeProduto;
    private LocalDate dataVenda;

    @OneToMany(mappedBy = "movimento")
    private List<Produto> produtos = new ArrayList<>();

    @ManyToOne
//    @JoinColumn(name = "id_cliente")
    private Cliente clientes;

    public Double valorProdutos(Produto produtos){
        Double valor = produtos.getValorProduto() * quantidadeProduto;
        return valor;
    }

    public Double valorTotal(){
        Double valor = 0.0;
        for (Produto produto : produtos){
            valor += produto.getValorProduto();
        }
        return valor;
    }

}
