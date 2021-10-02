package com.estoque.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.livraria.exception.NotFoundException;
import com.estoque.livraria.model.Livro;
import com.estoque.livraria.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro findById(Integer id) {
		Optional<Livro> livro = repository.findById(id);
		return livro.orElseThrow(() -> new NotFoundException("Objeto não encontrado! id: " + id + Livro.class));
	}
}