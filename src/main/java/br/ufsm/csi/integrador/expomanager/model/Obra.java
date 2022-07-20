package br.ufsm.csi.integrador.expomanager.model;

import javax.persistence.*;

@Entity
@Table
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_OBRA", unique = true)
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "IMAGEM")
    private byte[] imagem;

    @Column(name = "LINGUAGEM")
    @Enumerated(EnumType.STRING)
    private Linguagem linguagem;

    @Column(name = "TECNICA")
    @Enumerated(EnumType.STRING)
    private Tecnica tecnica;

    @Column(name = "ALTURA")
    private Float altura;

    @Column(name = "LARGURA")
    private Float largura;


}
