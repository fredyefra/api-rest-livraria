package com.estoque.livraria.repositories.criteria;

import java.util.List;

import com.estoque.livraria.model.Livro;

public interface LivroCriteria {

	public List<Livro> findByCategoria(Integer fkCategoria);
	
}
