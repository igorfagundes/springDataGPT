package com.springdatagpt.springgpt.service;
import com.springdatagpt.springgpt.repository.CategoriaRepository;
import com.springdatagpt.springgpt.repository.ProdutoRepository;
import com.springdatagpt.springgpt.orm.Categoria;
import com.springdatagpt.springgpt.orm.Produto;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class CrudCategoriaService {
    public CategoriaRepository categoriaRepository;

public CrudCategoriaService(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository){
    this.categoriaRepository = categoriaRepository;
    this.produtoRepository = produtoRepository;
}
//METODO MENU
public void menu(Scanner scanner){
    Boolean isTrue = true;
    while(isTrue){

        int opcao = scanner.nextInt();
        switch(opcao){
            case 1:

            break;
            default:

            break;
        }
    }
}
public void associarCategoria(Long produtoId, List<Long> categoriaId){
  
    Optional<Produto> opProduto = produtoRepository.findById(produtoId);
    if(opProduto.isPresent){

    }

    
}
}
