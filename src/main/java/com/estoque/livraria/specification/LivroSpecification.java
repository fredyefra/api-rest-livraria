package com.estoque.livraria.specification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.estoque.livraria.model.Categoria;
import com.estoque.livraria.model.Livro;

public class LivroSpecification {

	@Autowired
	private static EntityManager em;

	// Refactorar Lambda expressao
	public static Specification<Livro> byTitulo(String titulo) {

		return new Specification<Livro>() {

			private static final long serialVersionUID = 1L;

			public Predicate toPredicate(Root<Livro> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

				return cb.equal(root.get("titulo"), titulo);
			}
		};
	}

	// Refactorar Lambda expressao
	public static Specification<Livro> byCategoria(Integer fkCategoria) {

		return new Specification<Livro>() {

			private static final long serialVersionUID = 1L;

			public Predicate toPredicate(Root<Livro> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				Integer param = fkCategoria;
				Join<Livro, Categoria> fkCategoria = root.join("categoria");
				cq.orderBy(cb.asc(root.get("titulo")));

				return cb.equal(fkCategoria.get("identificador"), param);

			}
		};
	}

	// Refactorar Lambda expressao
	public static Specification<Livro> byNomeAutor(String nomeAutor) {

		return new Specification<Livro>() {

			private static final long serialVersionUID = 1L;

			public Predicate toPredicate(Root<Livro> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

				return cb.equal(root.get("nomeAutor"), nomeAutor);
			}
		};
	}

	// Refactorar Lambda expressao
	public static Specification<Livro> byTexto(String texto) {

		return new Specification<Livro>() {

			private static final long serialVersionUID = 1L;

			public Predicate toPredicate(Root<Livro> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

				return cb.equal(root.get("texto"), texto);
			}
		};
	}
}