package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends BaseException{
    public ProductNotFoundException() {
        super(HttpStatus.BAD_REQUEST, new ExceptionResponse("Product Not Found."));
    }
}