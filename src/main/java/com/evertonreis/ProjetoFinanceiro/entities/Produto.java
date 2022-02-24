package com.evertonreis.ProjetoFinanceiro.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nomeProduto;
    private Double valorProduto;
    private Integer estoque;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Movimento movimento;

    public Movimento getMovimento() {
        return movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
    }

    public void quantidadeEstoque(Movimento movimentos){
        Double totalEstoque = estoque - movimentos.getQuantidadeProduto();
    }
}
