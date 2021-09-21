package com.estoque.livraria.modelo;

import java.io.Serializable;

public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
    private Integer identificador;
    private String nomeAutor;
    private String texto;
    private Categoria categoria;
    
	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(Integer identificador, String nomeAutor, String texto) {
		super();
		this.identificador = identificador;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
	}


	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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

}
