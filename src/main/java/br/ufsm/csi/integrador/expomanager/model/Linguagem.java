package br.ufsm.csi.integrador.expomanager.model;

public enum Linguagem {
    PINTURA("Pintura"), DESENHO("Desenho"),
    GRAVURA("Gravura"), ESCULTURA("Escultura"),
    INSTALACAO("Instalação");

    private String descricao;

    private Linguagem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
