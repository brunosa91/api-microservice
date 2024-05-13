package com.ibmshop.api.cross;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ResourceExceptionHandler {

	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandarError> resourceNotFound(EntityNotFoundException e){
		String error = "Pequisa não encontrada";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(Instant.now(),status.value(),error,e.getMessage());
		return ResponseEntity.status(status).body(err);
	
	}
	
	public ResponseEntity<StandarError> serviceOut(EntityNotFoundException e){
		String error = "O serviço está fora do ar";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(Instant.now(),status.value(),error,e.getMessage());
		return ResponseEntity.status(status).body(err);
	
	}
	
	


	}
	
	
	

