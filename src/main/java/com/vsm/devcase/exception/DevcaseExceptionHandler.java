package com.vsm.devcase.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DevcaseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ DevcaseException.class })
	public ResponseEntity<?> handleDevCaseException(DevcaseException ex, WebRequest request) {
		return handleExceptionInternal(ex, new DevCaseError(ex.getMessage()), new HttpHeaders(), ex.getStatus(),
				request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return handleExceptionInternal(ex,
				new DevCaseError("O atributo " + ex.getParameterName() + " não foi encontrado!"), headers, status,
				request);
	}

	class DevCaseError {

		private String mensagem;

		public DevCaseError(String mensagem) {
			this.mensagem = mensagem;
		}

		public String getMensagem() {
			return mensagem;
		}

	}

}
