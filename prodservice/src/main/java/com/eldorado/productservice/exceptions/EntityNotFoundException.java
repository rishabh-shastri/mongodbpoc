package com.eldorado.productservice.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eldorado.productservice.constant.Constants;


public class EntityNotFoundException extends Exception {

	public EntityNotFoundException(String message) {
		super(message);
	}
}