package com.estoque.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.estoque.livraria.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>, 
                                         JpaSpecificationExecutor<Livro>  {

}
