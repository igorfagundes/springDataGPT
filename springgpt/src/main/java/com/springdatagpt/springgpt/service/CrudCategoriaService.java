package com.springdatagpt.springgpt.service;

import com.springdatagpt.springgpt.repository.CategoriaRepository;
import com.springdatagpt.springgpt.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import com.springdatagpt.springgpt.orm.Categoria;
import com.springdatagpt.springgpt.orm.Produto;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class CrudCategoriaService {
    public CategoriaRepository categoriaRepository;
    public ProdutoRepository produtoRepository;

public CrudCategoriaService(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository){
    this.categoriaRepository = categoriaRepository;
    this.produtoRepository = produtoRepository;
}
//METODO MENU
@Transactional
public void menu(Scanner scanner){
    Boolean isTrue = true;
    while(isTrue){
        System.out.println("### CATEGORIA ###");
        System.out.println("# Escolha uma OPCAO #");
        System.out.println("# [1] CRIE UMA CATEGORIA");
        System.out.println("# [2] CADASTRE UM PRODUTO");
        System.out.println("# [3] ASSOCIAR UM PRODUTO");
        System.out.println("# [0] SAIR");
        int opcao = scanner.nextInt();
        switch(opcao){
            case 1:
                cadastrar(scanner);
            break;
             case 2:
             cadastrarCategoriaProduto(scanner);
            break;
            case 3:
             associarCategoria(scanner);
            break;
            case 4:
            visualizar();
           break;
            default:
                isTrue = false;
            break;
        }
    }
}
//[1] CADASTRAR
public void cadastrar(Scanner scanner){
    System.out.println("### CADASTRAR ###");
    System.out.println("Digite o NOME da categoria");
    String nome = scanner.nextLine();

    Categoria categoria = new Categoria();
    categoria.setNome(nome);

    this.categoriaRepository.save(categoria);
    System.out.println("CATEGORIA " + categoria.getNome() + " cadastrado com sucesso!");
}
//[2] CADASTRAR UM PRODUTO EM UMA CATEGORIA

public void cadastrarCategoriaProduto(Scanner scanner){
    System.out.println("Digite o Id da CATEGORIA para adicionar PRODUTOS: ");
    Long id = scanner.nextLong();

    Optional<Categoria> optionalCat = this.categoriaRepository.findById(id);

    if(optionalCat.isPresent()){
        Categoria categoria = optionalCat.get();
        Set<Produto> novosProdutos = this.associarCategoria(scanner);
        categoria.getProdutos().addAll(novosProdutos);
        this.categoriaRepository.save(categoria);
    }else{
        System.out.println("O id da CATEGORIA informada: " + id + " é inválido\n");
    }
  }
  //[3] ASSOCIAR UM PRODUTO A UMA CATEGORIA
  @Transactional
public Set<Produto> associarCategoria(Scanner scanner){
    Boolean isTrue = true;
    Set<Produto> produtos = new HashSet<>();
    while(isTrue){
        System.out.println("ID do PRODUTO a obter uma categoria (digite 0 para sair): ");
        Long produtoId = scanner.nextLong();

        if(produtoId > 0){
            System.out.println("PRODUTO ID: " + produtoId);
            Optional<Produto> optional = this.produtoRepository.findById(produtoId);
            if(optional.isPresent()){
                produtos.add(optional.get());
            }else{
                System.out.println("Nenhum PRODUTO possui Id " + produtoId + " !");
            }
        }else{
            isTrue = false;
        }
    }
    return produtos;
  }
  private void visualizar(){
    Iterable<Categoria> categorias = this.categoriaRepository.findAll();
    //alternativa 1
    for (Categoria categoria : categorias) {
       
        System.out.println(categoria);
    }

    //alternativa 2
    //professores.forEach(professor ->{
     //   System.out.println(professor);
    //});

    //alternativa 3
   // professores.forEach(System.out::println);
    System.out.println();
}
  
}

