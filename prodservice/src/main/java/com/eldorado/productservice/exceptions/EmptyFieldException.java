package com.eldorado.productservice.exceptions;

import com.eldorado.productservice.constant.Constants;

public class EmptyFieldException extends Exception{

	public EmptyFieldException(String message) {
		super(message+Constants.emptyField);
	}

}
