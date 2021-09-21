package com.estoque.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estoque.livraria.modelo.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>  {

}
