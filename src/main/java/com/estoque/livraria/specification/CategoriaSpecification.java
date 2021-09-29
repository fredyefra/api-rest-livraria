package com.estoque.livraria.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.estoque.livraria.model.Categoria;

public class CategoriaSpecification {

	/*
	 * public static Specification<Categoria> byNome(String nome) {
	 * 
	 * return (root, query, builder) -> builder.like(root.get("nome"), nome); }
	 */

	   //Refactorar Lambda expressao
		public static Specification<Categoria> byNome(String nome) {
			return new Specification<Categoria>() {

			public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> cq,	
						CriteriaBuilder cb) {
					
					return cb.equal(root.get("nome"), nome);
				}
			};
		}
	
	//Refactorar Lambda expressao
	public static Specification<Categoria> byDescricao(String descricao) {
		return new Specification<Categoria>() {

		public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> cq,	
					CriteriaBuilder cb) {
				
				return cb.equal(root.get("descricao"), descricao);
			}
		};
	}
}