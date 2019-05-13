package edu.eci.arsw.evern.controller;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EvernException extends Exception{

    private static final long serialVersionUID = 1L;
    
    public EvernException(String message) {
		super(message);
	}
	
	public EvernException(String message, Throwable cause) {
        super(message, cause);
	}
    
}