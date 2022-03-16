package com.estoque.livraria.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.livraria.dto.CategoriaDTO;
import com.estoque.livraria.model.Categoria;
import com.estoque.livraria.service.CategoriaService;

@CrossOrigin("*")
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
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria) {

		categoria.setIdentificador(null);
		//categoria.setNome("Teste");
		//categoria.setDescricao("Descricao");
		
		Categoria resposta = service.save(categoria);

		
		
		/*
		 * URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		 * .buildAndExpand(resposta.getIdentificador()).toUri();
		 */
		// return ResponseEntity.created(uri).build();

		return ResponseEntity.created(URI.create("/categorias/" + resposta.getIdentificador())).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@Valid @PathVariable Integer id, @RequestBody CategoriaDTO dto) {
		Categoria categoria = service.update(id, dto);
		return ResponseEntity.ok().body(new CategoriaDTO(categoria));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}