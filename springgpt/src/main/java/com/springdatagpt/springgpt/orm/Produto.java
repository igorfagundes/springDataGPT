package com.springdatagpt.springgpt.orm;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    public String nome;
    public String descricao;
    public Double preco;
    public Categoria categoria;

    @ManyToMany
    private List<Categoria> categorias;
    
//GETTERS AND SETTERS(SEM SET ID)
    public Long getId() {
        return id;
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
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Iterable<Categoria> categoria2) {
        this.categoria = categoria2;
    }
    //TO STRING
    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", categoria="
                + categoria + "]";
    }
    

    




}