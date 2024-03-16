package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class ProductNotFoundException extends BaseException{

    public ProductNotFoundException() {
        super(HttpStatus.BAD_REQUEST, "Product Not Found");
    }
}
