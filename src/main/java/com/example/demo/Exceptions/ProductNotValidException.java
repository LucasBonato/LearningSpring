package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotValidException extends BaseException {
    public ProductNotValidException(String message) {
        super(HttpStatus.BAD_REQUEST, new ExceptionResponse(message));
    }
}