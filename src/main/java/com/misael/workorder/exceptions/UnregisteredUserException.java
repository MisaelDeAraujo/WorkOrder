package com.misael.workorder.exceptions;

/**
 * UnregisteredUserException
 */
public class UnregisteredUserException extends RuntimeException{

    public UnregisteredUserException(String description){
        super(description);
    }
    
}