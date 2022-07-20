package br.ufsm.csi.integrador.expomanager.model;

public enum Tecnica {
    MISTA_SOBRE_MADEIRA("Técnica mista sobre madeira"),
    MISTA_SOBRE_TELA("Técnica mista sobre tela"),
    OLEO_SOBRE_TELA("Óleo sobre tela"),
    OLEO_SOBRE_MADEIRA("Óleo sobre madeira"),
    ACRILICA_SOBRE_TELA("Acrílica sobre tela"),
    ACRILICA_SOBRE_MADEIRA("Acrílica sobre madeira"),
    ACRILICA_SOBRE_PAPEL("Acrílica sobre papel"),
    TEMPERA_SOBRE_PAPEL("Têmpera sobre papel"),
    TEMPERA_SOBRE_CARTAO("Têmpera sobre cartão"),
    AGUA_FORTE("Água forte"),
    AGUA_TINTA("Água tinta"), PONTA_SECA("Ponta seca"),
    XILOGRAVURA("Xilogravura"),
    BRONZE("Escultura fundida em bronze"),
    METAIS_MISTOS("Escultura fundida em metais mistos"),
    MISTA("Materiais variados");

    private String descricao;

    private Tecnica(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
