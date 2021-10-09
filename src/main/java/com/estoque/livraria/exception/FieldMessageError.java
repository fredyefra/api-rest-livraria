package com.estoque.livraria.exception;

import java.io.Serializable;

/**
 * Captura o erro no campo[field] e a respectiva mensagem[message] de validação
 **/
public class FieldMessageError implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;

	public FieldMessageError() {

	}

	public FieldMessageError(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}