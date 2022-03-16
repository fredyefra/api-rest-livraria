package com.estoque.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.livraria.dto.LivroDTO;
import com.estoque.livraria.exception.NotFoundException;
import com.estoque.livraria.model.Categoria;
import com.estoque.livraria.model.Livro;
import com.estoque.livraria.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private CategoriaService categoriaService;

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public List<Livro> findByCategoria(Integer fkCategoria) {
		return repository.findByCategoria(fkCategoria);
	}

	public Livro findById(Integer id) {
		Optional<Livro> livro = repository.findById(id);
		return livro.orElseThrow(() -> new NotFoundException("Objeto não encontrado! id: " + id + Livro.class));
	}

	public Livro save(Integer id_cat, Livro livro) {
		livro.setIdentificador(null);
		Categoria categoria = categoriaService.findById(id_cat);
		livro.setCategoria(categoria);
		return repository.save(livro);
	}

	public Livro update(Integer id, LivroDTO dto) {
		Livro livro = findById(id); // if id exist jpa update object
		livro.setTitulo(dto.getTitulo());
		livro.setNomeAutor(dto.getNomeAutor());
		livro.setTexto(dto.getTexto());
		return repository.save(livro);
	}

	public void delete(Integer id) {
		Livro livro = findById(id);
		repository.delete(livro);
	}

}