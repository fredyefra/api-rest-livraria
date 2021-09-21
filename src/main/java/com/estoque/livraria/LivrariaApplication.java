package com.estoque.livraria;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estoque.livraria.modelo.Categoria;
import com.estoque.livraria.modelo.Livro;
import com.estoque.livraria.repositories.CategoriaRepository;
import com.estoque.livraria.repositories.LivroRepository;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de T.I");
		
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1); 
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1));
		livroRepository.saveAll(Arrays.asList(l1));
		
	}

	
	
}
