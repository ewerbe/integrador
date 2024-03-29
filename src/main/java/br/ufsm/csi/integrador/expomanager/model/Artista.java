package br.ufsm.csi.integrador.expomanager.model;

import javax.persistence.*;

@Entity
@Table
public class Artista{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ARTISTA", unique = true)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PAIS_ORIGEM")
    private String paisOrigem;

    @Column(name = "ANO_NASCIMENTO")
    private Long anoNascimento;

    @Column(name = "ANO_MORTE")
    private Long anoMorte;

    public Artista(String nome, String paisOrigem, Long anoNascimento, Long anoMorte) {
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.anoNascimento = anoNascimento;
        this.anoMorte = anoMorte;
    }

    public Artista() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public Long getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Long anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Long getAnoMorte() {
        return anoMorte;
    }

    public void setAnoMorte(Long anoMorte) {
        this.anoMorte = anoMorte;
    }
}

