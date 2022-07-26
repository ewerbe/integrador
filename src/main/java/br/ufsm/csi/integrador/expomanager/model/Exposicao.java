package br.ufsm.csi.integrador.expomanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Exposicao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_EXPOSICAO", unique = true)
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @OneToOne
    @JoinColumn(name="id_usuario_gerente")
    private Usuario usuarioGerente;

    @Column(name = "DESCRICAO")
    @Lob
    private String descricao;

    @Column(name = "DATA_INICIO")
    private Date dataInicio;

    @Column(name = "DATA_FIM")
    private Date dataFim;

    @Column(name = "BANNER")
    private byte[] banner;

    @Column(name = "BANNER_STRING")
    private String bannerString;

    @Column(name = "ATIVA")
    private Boolean ativa;

    @Column(name = "ACERVO")
    private Boolean acervo;

    @ManyToMany
    @JoinTable(
            name = "EXPO_OBRA",
            joinColumns = @JoinColumn(name = "ID_EXPOSICAO"),
            inverseJoinColumns = @JoinColumn(name = "ID_OBRA"))
    private Set<Obra> obras;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuarioGerente() {
        return usuarioGerente;
    }

    public void setUsuarioGerente(Usuario usuarioGerente) {
        this.usuarioGerente = usuarioGerente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public byte[] getBanner() {
        return banner;
    }

    public void setBanner(byte[] banner) {
        this.banner = banner;
    }

    public String getBannerString() {
        return bannerString;
    }

    public void setBannerString(String bannerString) {
        this.bannerString = bannerString;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Boolean getAcervo() {
        return acervo;
    }

    public void setAcervo(Boolean acervo) {
        this.acervo = acervo;
    }

    public Set<Obra> getObras() {
        return obras;
    }

    public void setObras(Set<Obra> obras) {
        this.obras = obras;
    }
}
