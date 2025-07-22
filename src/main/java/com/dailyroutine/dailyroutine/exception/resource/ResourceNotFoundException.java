package com.dailyroutine.dailyroutine.exception.resource;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
