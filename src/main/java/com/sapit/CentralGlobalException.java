package com.sapit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralGlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> getResourseNotFound(ResourceNotFoundException e) {
		System.out.println("hi------------------");
		return new ResponseEntity<String>(e.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> getNullPointerException(NullPointerException e) {
		System.out.println("hi-----------NULL-------"+e.getMessage());
		return new ResponseEntity<String>("Technical Issue",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
