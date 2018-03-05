package com.example.demo.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionResponseHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		
		
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setTimestamp(new Date());
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.addDetail(request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DataNotFoundException.class)
	public final ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException ex, WebRequest request) {
		
		
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setTimestamp(new Date());
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.addDetail(request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Object> errors = new ArrayList<Object>();
		
		Map<Object, Object> fields = ex.getBindingResult()
								.getFieldErrors()
								.stream()
								.collect(Collectors.toMap(e -> String.format("%s.%s", e.getObjectName(), e.getField()), e-> e.getDefaultMessage())); 
		
		errors.add(fields);
									  
		ExceptionResponse response = new ExceptionResponse(new Date(), "Os dados enviados contém erros.", errors);
		
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	
	
}
