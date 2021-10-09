package com.estoque.livraria.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.livraria.dto.LivroDTO;
import com.estoque.livraria.model.Livro;
import com.estoque.livraria.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService service;

	/*
	 * @GetMapping("/") public ResponseEntity<List<LivroDTO>> findAll() {
	 * List<Livro> livros = service.findAll(); List<LivroDTO> dto =
	 * livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
	 * 
	 * return ResponseEntity.ok().body(dto); }
	 */

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findLivroByCategoria(
			@RequestParam(value = "categoria", defaultValue = "0") Integer fkCategoria) {
		// localhost:8080/livros?categoria=1
		List<Livro> livros = service.findByCategoria(fkCategoria);
		List<LivroDTO> dto = livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro livro = service.findById(id);
		return ResponseEntity.ok().body(livro);
	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
			@RequestBody Livro livro) {
		// nao existe livro sem categoria @RequestParam(value = "categoria",
		// defaultValue = "0")
		Livro resposta = service.save(id_cat, livro);
		return ResponseEntity.created(URI.create("/livros/" + resposta.getIdentificador())).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @RequestBody LivroDTO dto) {
		Livro livro = service.update(id, dto);
		return ResponseEntity.ok().body(new LivroDTO(livro));
	}
}