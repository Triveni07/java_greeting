package com.learning.greeting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { GreetingException.class })
	protected ResponseEntity<ErrorDetails> handleGreetingException(GreetingException ex, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),
				ex.getErrorCode());
		HttpStatus status = HttpStatus.valueOf(ex.getErrorCode());

		return new ResponseEntity<>(errorDetails, status);
	}
}