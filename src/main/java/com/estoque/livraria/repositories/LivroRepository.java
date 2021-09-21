package com.estoque.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estoque.livraria.modelo.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>  {

}
