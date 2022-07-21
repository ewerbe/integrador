package br.ufsm.csi.integrador.expomanager.model;

import javax.persistence.*;

@Entity
@Table
public class Prateleira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PRATELEIRA", unique = true)
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "ATIVA")
    private Boolean ativa;
}
