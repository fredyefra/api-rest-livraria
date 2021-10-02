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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estoque.livraria.dto.CategoriaDTO;
import com.estoque.livraria.model.Categoria;
import com.estoque.livraria.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	// @GetMapping
	// public ResponseEntity<List<Categoria>> findAll() {
	// List<Categoria> categorias = service.findAll();
	// return ResponseEntity.ok().body(categorias);
	// }

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {

		List<Categoria> entidades = service.findAll();
		List<CategoriaDTO> entidadesDTO = entidades.stream().map(obj -> new CategoriaDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(entidadesDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria categoria = service.findById(id);
		return ResponseEntity.ok().body(categoria);
	}

	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {

		Categoria resposta = service.save(categoria);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(resposta.getIdentificador()).toUri();

		// return ResponseEntity.created(uri).body(resposta);
		return ResponseEntity.created(uri).build();

	}

	@PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO dto) {
	Categoria categoria	= service.update(id,dto);
    	return ResponseEntity.ok().body(new CategoriaDTO(categoria));
	}
}