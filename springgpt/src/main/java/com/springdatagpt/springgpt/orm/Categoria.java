package com.springdatagpt.springgpt.orm;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Categoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String nome;

    @ManyToMany(mappedBy = "categorias", fetch = FetchType.EAGER)
    private List<Produto> produtos;
    
    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    //TO STRING
    @Override
    public String toString() {
        return "Categoria [id=" + id + ", nome=" + nome + ", produtos=" + produtos + "]";
    }

    
}