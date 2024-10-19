package com.auth.service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleValidationExceptions(ConstraintViolationException ex) {
		StringBuilder errors = new StringBuilder();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.append(violation.getMessage()).append("\n");
		}
		return ResponseEntity.badRequest().body(errors.toString());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleExceptions(Exception ex) {

		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}
