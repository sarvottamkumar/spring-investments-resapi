package com.investmentapp.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.investmentapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("error", "Method not allowed");
		List<String> errorMsg = new ArrayList<>();
		errorMsg.add(ex.getMessage());
		errorMsg.add(request.toString());
		
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),ex.getMessage(),status.value(),errorMsg);
		
		
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("error", "Media type not supported");
		List<String> errorMsg = new ArrayList<>();
		errorMsg.add(ex.getMessage());
		errorMsg.add(request.toString());
		
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),ex.getMessage(),status.value(),errorMsg);
		
		
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		headers.add("error", "miss match path variable");
		List<String> errorMsg = new ArrayList<>();
		errorMsg.add(ex.getMessage());
		errorMsg.add(request.toString());
		
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),ex.getMessage(),status.value(),errorMsg);
		
		
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("error", " Request Param is missing");
		List<String> errorMsg = new ArrayList<>();
		errorMsg.add(ex.getMessage());
		errorMsg.add(request.toString());
		
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),ex.getMessage(),status.value(),errorMsg);
		
		
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		headers.add("error", "type missmatch");
		List<String> errorMsg = new ArrayList<>();
		errorMsg.add(ex.getMessage());
		errorMsg.add(request.toString());
		
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),ex.getMessage(),status.value(),errorMsg);
		
		
		return ResponseEntity.status(status).headers(headers).body(errors);
	}
	
	@ExceptionHandler(PlanNotFoundException.class)
	public ResponseEntity<Object> handlePlanNotFound(PlanNotFoundException ex){
		HttpHeaders headers = new HttpHeaders();
		headers.add("error", ex.getMessage());
		List<String> errorMsg = new ArrayList<>();
		errorMsg.add(ex.getMessage());
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),ex.getMessage(),HttpStatus.CONFLICT.value(),errorMsg);
		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
		
	}
	
	

}
