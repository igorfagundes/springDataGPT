package com.springdatagpt.springgpt.service;

import java.text.BreakIterator;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.springdatagpt.springgpt.orm.Produto;
import com.springdatagpt.springgpt.repository.CategoriaRepository;
import com.springdatagpt.springgpt.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class CrudProdutoService {
    public ProdutoRepository produtoRepository;
    public CategoriaRepository categoriaRepository;

public CrudProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository){
    this.produtoRepository = produtoRepository;
    this.categoriaRepository = categoriaRepository;
}
//METODO MENU

public void menu(Scanner scanner){
    Boolean isTrue = true;
    while(isTrue){
        System.out.println("### MENU ###");
        System.out.println("# [1] CADASTRAR");
        System.out.println("# [2] BUSCAR POR ID");
        System.out.println("# [0] SAIR");
        int opcao = scanner.nextInt();

        switch(opcao){
            case 1:
                cadastrar(scanner);
            break;
            case 2:
                buscarPorId(scanner);
            break;
            default:
                isTrue = false;
            break;
        }
    }
}
//METODO CADASTRAR
public void cadastrar(Scanner scanner){
    Scanner scan = new Scanner(System.in);
    System.out.println("### CADASTRAR ###");
    System.out.println("Digite o NOME do produto");
    String nome = scan.nextLine();
    System.out.println("Digite uma breve DESCRICAO");
    String descricao = scan.nextLine();
    System.out.println("Digite o PRECO do produto");
    Double preco = scan.nextDouble();

    Produto produto = new Produto();
    produto.setNome(nome);
    produto.setDescricao(descricao);
    produto.setPreco(preco);

    this.produtoRepository.save(produto);
    System.out.println("PRODUTO " + produto.getNome() + " cadastrado com sucesso!");
}
//METODO BUSCAR POR ID

public void buscarPorId(Scanner scanner){
    System.out.print("Digite o ID do PRODUTO: ");
    Long id = scanner.nextLong();

    Optional<Produto> opProduto = produtoRepository.findById(id);
    if(opProduto.isPresent()){
        Produto produto = opProduto.get();

        System.out.println("### PRODUTO ###");
        System.out.println("# ID: " + produto.getId());
        System.out.println("# NOME: " + produto.getNome());
        System.out.println("# DESCRICAO: " + produto.getDescricao());
        System.out.println("# PRECO: " + produto.getPreco());
        System.out.println("################");
    }
}
}
