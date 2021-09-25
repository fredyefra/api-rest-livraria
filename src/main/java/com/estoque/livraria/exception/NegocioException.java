package com.estoque.livraria.exception;

public class NegocioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegocioException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NegocioException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
