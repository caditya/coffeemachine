package com.cofeeshop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="This coffee is not in inventory")
public class CoffeeNotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;

}
