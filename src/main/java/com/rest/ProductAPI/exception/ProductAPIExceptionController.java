package com.rest.ProductAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rest.ProductAPI.model.CommonError;

@ControllerAdvice
public class ProductAPIExceptionController {
	CommonError error;
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> notFoundException(ProductNotFoundException exception){
		error=new CommonError();
		error.setErrorCode("404");
		error.setErrorMessage("Product Not Found");
		error.setErrorType(HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
