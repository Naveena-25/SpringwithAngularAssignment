package com.capgemini.angularproject.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.angularproject.bean.ProductResponse;
import com.capgemini.angularproject.exception.ProductException;
@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler
	public ProductResponse exceptionHandler(ProductException productException) {
		ProductResponse response = new ProductResponse();
		response.setError(true);
		response.setMessage(productException.getMessage());

		return response;
	}
}
