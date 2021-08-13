package com.batista.loja.exceptionhandler;

import java.time.OffsetDateTime;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { EmptyResultDataAccessException.class })
	protected ResponseEntity<Object> handleEmptyResultDataAccess(EmptyResultDataAccessException ex,
			WebRequest request) {
		Trouble trouble = new Trouble();
		HttpStatus error = HttpStatus.INTERNAL_SERVER_ERROR;
		trouble.setTimestamp(OffsetDateTime.now());
		trouble.setStatus(error.value());
		trouble.setError(error.getReasonPhrase());
		trouble.setMessage(ex.getMessage());

		return handleExceptionInternal(ex, trouble, new HttpHeaders(), error, request);
	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
		Trouble trouble = new Trouble();
		HttpStatus error = HttpStatus.NOT_FOUND;
		trouble.setTimestamp(OffsetDateTime.now());
		trouble.setStatus(error.value());
		trouble.setError(error.getReasonPhrase());
		trouble.setMessage(ex.getMessage());

		return handleExceptionInternal(ex, trouble, new HttpHeaders(), error, request);
	}

}
