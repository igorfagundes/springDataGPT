package com.springdatagpt.springgpt.repository;

import org.springframework.data.repository.CrudRepository;
import com.springdatagpt.springgpt.orm.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
    
}
