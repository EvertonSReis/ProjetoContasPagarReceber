//package com.evertonreis.ProjetoFinanceiro.entities;
//
//import com.evertonreis.ProjetoFinanceiro.entities.enums.TipoConta;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDate;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
//@Table(name = "tb_fluxo")
//public class Fluxo implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;
//
//    private TipoConta tipoConta;
//
//    @ManyToOne
//    private Cliente cliente;
//    @ManyToOne
//    private Movimento movimento;
//    private Double totalMovimento = movimento.valorTotal();
//    private LocalDate dataLançamento = movimento.getDataVenda();
//    private LocalDate dataVencimento;
//    private String observacao;
//
//}
