package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends BaseException{
    public ProductNotFoundException() {
        super(HttpStatus.NOT_FOUND, new ExceptionResponse("Product Not Found."));
    }
}