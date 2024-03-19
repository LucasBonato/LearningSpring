package com.example.demo.Product.Command;

import org.springframework.http.ResponseEntity;

public interface Command<E, T>{
    ResponseEntity<T> execute(E entity);
}