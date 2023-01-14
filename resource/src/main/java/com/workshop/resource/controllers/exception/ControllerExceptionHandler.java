package com.workshop.resource.controllers.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.workshop.resource.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest request) {
		StandardError err = new StandardError(
				new Date().toInstant(), 
				HttpStatus.NOT_FOUND.value(), 
				objectNotFoundException.getMessage(), 
				request.getRequestURI().toString());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
