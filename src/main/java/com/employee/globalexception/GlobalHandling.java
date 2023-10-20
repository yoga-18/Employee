package com.employee.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.customexception.IdNotFoundException;
import com.employee.customexception.SalaryNotValidException;

@RestControllerAdvice
public class GlobalHandling {
@ExceptionHandler(IdNotFoundException.class)
public ResponseEntity<Object> idHandling(){
	
	return new ResponseEntity<>("Sorry this is not valid Id",HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(SalaryNotValidException.class)
public ResponseEntity<Object> salHandling(){
	return new ResponseEntity<>("Not a valid Salary",HttpStatus.BAD_REQUEST);
}
}
