package com.example.udmeyassigment.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvie {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List<String>> handleValidationException(ConstraintViolationException e) {

		return new ResponseEntity<List<String>>(e.getConstraintViolations().stream()
				.map(err -> err.getPropertyPath() + "|" + err.getMessage()).collect(Collectors.toList()),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<List> handlebindnException(BindException e) {

		return new ResponseEntity<List>(e.getAllErrors(), HttpStatus.BAD_REQUEST);

	}

}
