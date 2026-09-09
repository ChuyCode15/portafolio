package com.makingbigger.portafoliojmc.infrastructure.exception;

public class ResourceNotFoundException extends RuntimeException {
    /*private final String messageEn;
    private final String messageEs; todo pendiente ajustar respueta bilingue*/

    public  ResourceNotFoundException(String message) {
        super(message);
    }
}
