package com.maiso.alura_eclipse.modelo;

import android.widget.RatingBar;

import java.io.Serializable;

/**
 * Created by maiso on 10/12/2016.
 */

public class Aluno implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String nome;
    private String endereco;
    private String telefone;
    private String site;
    private Double nota;
    private String caminhodaFoto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getCaminhodaFoto() {
        return caminhodaFoto;
    }

    public void setCaminhodaFoto(String caminhodaFoto) {
        this.caminhodaFoto = caminhodaFoto;
    }

    @Override
    public String toString() {
        return this.id+"  -  "+this.nome;
    }
}
