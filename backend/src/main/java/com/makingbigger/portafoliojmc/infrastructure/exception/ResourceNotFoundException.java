package com.makingbigger.portafoliojmc.infrastructure.exception;

public class ResourceNotFoundException extends RuntimeException {
    public  ResourceNotFoundException(String message) {
        super(message);
    }
}
