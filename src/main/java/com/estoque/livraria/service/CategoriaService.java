package com.estoque.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.livraria.CategoriaDTO;
import com.estoque.livraria.exception.NotFoundException;
import com.estoque.livraria.model.Categoria;
import com.estoque.livraria.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll() {

		// String descricao = "Livros de T.I";
		// return repository.findAll(CategoriaSpecification.byDescricao(descricao));
		return repository.findAll();
	}

	
	
	
	public Categoria save(Categoria categoria) {
		return repository.save(categoria);
	}

	public Categoria findById(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new NotFoundException("Objeto não encontrado! id: " + id + Categoria.class));
	}
}