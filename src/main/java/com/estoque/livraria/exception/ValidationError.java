package com.estoque.livraria.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	
	private List<FieldMessageError> errors = new ArrayList<FieldMessageError>();
	
	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	* Herda o construtor da superclasse
	* 
	*/
	public ValidationError(Long timeStamp, Integer status, String message) {
		super(timeStamp, status, message);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessageError> getErrors() {
		return errors;
	}

	/**
	* Adiciona os erros individualmente na lista para tratamento
	* @param 
	*/
	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessageError(fieldName, message));
	}

	
	
	
	
}
