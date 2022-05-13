package com.prova.series.models;

public class Series {
    private String nome;
    private String descricao;
    private String nome_autor;
    private String nome_diretor;
    private Integer qtd_temporadas;
    private Integer id;

    Series() {

    }

    public Series(String nome, String descricao, String nome_autor, String nome_diretor, Integer qtd_temporadas, Integer id) {
        this.nome = nome;
        this.descricao = descricao;
        this.nome_autor = nome_autor;
        this.nome_diretor = nome_diretor;

        this.qtd_temporadas = qtd_temporadas;

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getNome_diretor() {
        return nome_diretor;
    }

    public void setNome_diretor(String nome_diretor) {
        this.nome_diretor = nome_diretor;
    }

    public Integer getQtd_temporadas() {
        return qtd_temporadas;
    }

    public void setQtd_temporadas(Integer qtd_temporadas) {
        this.qtd_temporadas = qtd_temporadas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}