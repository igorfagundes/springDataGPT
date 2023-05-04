package com.springdatagpt.springgpt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProdutoController {

    private final ProdutoService produtoService;
    
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/produtos/{produtoId}/categorias")
    public void associarCategoria(@PathVariable Long produtoId, @RequestBody List<Long> categoriaIds) {
        produtoService.associarCategoria(produtoId, categoriaIds);
    }
}
