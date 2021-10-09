package com.estoque.livraria.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer identificador;
	private String titulo;
	private String nomeAutor;
	private String texto;

	private Categoria categoria;

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(Integer identificador, String titulo, String nomeAutor, String texto, Categoria categoria) {
		super();
		this.identificador = identificador;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
		this.categoria = categoria;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	@NotEmpty(message = "Campo TIULO é requerido")
	@Length(min = 3, max = 50, message = "O Campo TITULO deve ter entre 3 e 50 caracteres")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@NotEmpty(message = "Campo NOME DO AUTOR é requerido")
	@Length(min = 3, max = 200, message = "O Campo NOME AUTOR deve ter entre 3 e 200 caracteres")
	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	@NotEmpty(message = "Campo TEXTO é requerido")
	@Length(min = 3, max = 200000, message = "O Campo TEXTO deve ter entre 10 e 200000 caracteres")
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

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
		Livro other = (Livro) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [identificador=" + identificador + "]";
	}
}