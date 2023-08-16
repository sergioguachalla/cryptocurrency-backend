package com.example.backend.exceptions;

public class CryptocurrencyUpdateException extends RuntimeException {
    public CryptocurrencyUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
