package com.maersk.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerException {
	
	 @ExceptionHandler(value = { ValidateException.class })
	    public ErrorResponse validationEx(Exception ex,String message)
	    {
	        return new ErrorResponse(422,message);
	    }

}
