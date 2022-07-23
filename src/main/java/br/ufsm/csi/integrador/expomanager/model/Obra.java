package br.ufsm.csi.integrador.expomanager.model;

import javax.persistence.*;

@Entity
@Table
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_OBRA", unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name="id_artista")
    private Artista artista;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "IMAGEM")
    private byte[] imagem;

    private String imagemString;

    @OneToOne
    @JoinColumn(name="id_linguagem")
    private Linguagem linguagem;

    @OneToOne
    @JoinColumn(name="id_tecnica")
    private Tecnica tecnica;

    @OneToOne
    @JoinColumn(name="id_prateleira")
    private Prateleira prateleira;

    @Column(name = "ALTURA")
    private Float altura;

    @Column(name = "LARGURA")
    private Float largura;

    /////////////////////////////////////


    public Obra() {
    }

    public Obra(Artista artista, String titulo, byte[] imagem, Linguagem linguagem, Tecnica tecnica,
                Prateleira prateleira, Float altura, Float largura) {
        this.artista = artista;
        this.titulo = titulo;
        this.imagem = imagem;
        this.linguagem = linguagem;
        this.tecnica = tecnica;
        this.prateleira = prateleira;
        this.altura = altura;
        this.largura = largura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getImagemString() {
        return imagemString;
    }

    public void setImagemString(String imagemString) {
        this.imagemString = imagemString;
    }

    public Linguagem getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(Linguagem linguagem) {
        this.linguagem = linguagem;
    }

    public Tecnica getTecnica() {
        return tecnica;
    }

    public void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }

    public Prateleira getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(Prateleira prateleira) {
        this.prateleira = prateleira;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getLargura() {
        return largura;
    }

    public void setLargura(Float largura) {
        this.largura = largura;
    }
}
