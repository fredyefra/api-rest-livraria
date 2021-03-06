package com.estoque.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.estoque.livraria.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>, 
                                             JpaSpecificationExecutor<Categoria> {

}
