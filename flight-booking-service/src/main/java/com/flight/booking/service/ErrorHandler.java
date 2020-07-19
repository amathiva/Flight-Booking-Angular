package com.flight.booking.service;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleErrors(Exception e)
	{
		System.out.println("At error class");
		ErrorMessage em = new ErrorMessage(e.getMessage(), "Processing Failed at Server", new Date());
		ResponseEntity res = new ResponseEntity(em, HttpStatus.INTERNAL_SERVER_ERROR);
		return res;
	}
	
	@ExceptionHandler(FilterDoesNotMatchException.class)
	public ResponseEntity<?> handleCriteriaErrors(FilterDoesNotMatchException e)
	{
		System.out.println("At error class1");
		ErrorMessage em = new ErrorMessage(e.getMessage(), "Please change filter values", new Date());
		ResponseEntity res = new ResponseEntity(em, HttpStatus.NOT_FOUND);
		return res;
	}

}
