package com.ibmshop.productsapi.cross;

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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity FixError400(MethodArgumentNotValidException e) {
		var err = e.getFieldErrors();
        return ResponseEntity.badRequest().body(err.stream().map(DataErrorValidation::new).toList());
    }
	
	private record DataErrorValidation(String campo , String mensagem) {
		public DataErrorValidation(FieldError err) {
			this(err.getField(), err.getDefaultMessage());
		}
		
	}
	
	
	
}
