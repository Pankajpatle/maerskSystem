package com.maersk.Exception;

public class ValidateException extends RuntimeException{
	
	public ValidateException() {
        super();
    }

    public ValidateException(String message) {
        super(message);
    }

}
