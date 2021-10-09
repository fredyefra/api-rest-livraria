package com.estoque.livraria.dto;

import java.io.Serializable;

import com.estoque.livraria.model.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer identificador;
	private String titulo;
	// private String nomeAutor;
	// private String texto;

	// private Categoria categoria;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro entidade) {
		super();
		this.identificador = entidade.getIdentificador();
		this.titulo = entidade.getTitulo();
		// this.nomeAutor = entidade.getNomeAutor();
		// this.texto = entidade.getTexto();
		// this.setCategoria(entidade.getCategoria());
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/*
	 * public String getNomeAutor() { return nomeAutor; }
	 * 
	 * public void setNomeAutor(String nomeAutor) { this.nomeAutor = nomeAutor; }
	 * 
	 * public String getTexto() { return texto; }
	 * 
	 * public void setTexto(String texto) { this.texto = texto; }
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroDTO other = (LivroDTO) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LivroDTO [identificador=" + identificador + "]";
	}

}