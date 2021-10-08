package com.estoque.livraria.repositories.criteria.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.estoque.livraria.model.Categoria;
import com.estoque.livraria.model.Livro;
import com.estoque.livraria.repositories.criteria.LivroCriteria;

public class LivroCriteriaImpl implements LivroCriteria {

	@Autowired
	private EntityManager em;

	@Override
	public List<Livro> findByCategoria(Integer fkCategoria) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Livro> cq = cb.createQuery(Livro.class);
		Root<Livro> root = cq.from(Livro.class);
		Join<Livro, Categoria> join = root.join("categoria");
		
		cq.select(root).where(cb.equal(join.get("identificador"), fkCategoria));
		
		return em.createQuery(cq).getResultList();
	}

}