package com.vsm.devcase.exception;

import org.springframework.http.HttpStatus;

/**
 * Classe de Exceções Personalizada.
 * OBS: Recebe um HttpStatus, que é usado posteriormente para o retorno de  método de resposta!
 * @author Gabriel Alan
 *
 */
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
