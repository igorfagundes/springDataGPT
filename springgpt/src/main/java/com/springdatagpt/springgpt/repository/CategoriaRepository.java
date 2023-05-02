package com.springdatagpt.springgpt.repository;

import org.springframework.data.repository.CrudRepository;
import com.springdatagpt.springgpt.orm.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
    
}
