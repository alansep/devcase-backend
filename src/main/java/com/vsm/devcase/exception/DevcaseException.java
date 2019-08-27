package com.vsm.devcase.exception;

import org.springframework.http.HttpStatus;

public class DevcaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;

	public DevcaseException(String mensagem, HttpStatus status) {
		super(mensagem);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	
}
