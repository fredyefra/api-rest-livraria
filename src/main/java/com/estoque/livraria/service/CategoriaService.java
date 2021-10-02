package com.estoque.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.livraria.dto.CategoriaDTO;
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

	public Categoria findById(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new NotFoundException("Objeto não encontrado! id: " + id + Categoria.class));
	}

	public Categoria save(Categoria categoria) {
		categoria.setIdentificador(null); // if id null jpa create new object
		return repository.save(categoria);
	}

	public Categoria update(Integer id, CategoriaDTO dto) {
		Categoria categoria = findById(id); // if id exist jpa update object
		categoria.setNome(dto.getNome());
		categoria.setDescricao(dto.getDescricao());
		return repository.save(categoria);
	}

	public void delete(Integer id) {
		Categoria categoria = findById(id);
		repository.delete(categoria);
		//return null;
	}

}