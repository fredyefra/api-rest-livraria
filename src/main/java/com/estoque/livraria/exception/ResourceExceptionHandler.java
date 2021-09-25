package com.estoque.livraria.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	// https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<StandardError> notFoundException(NegocioException exception, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	//@ExceptionHandler(NegocioException.class)
	public ResponseEntity<StandardError> badRequestException(NegocioException exception, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

	}

}