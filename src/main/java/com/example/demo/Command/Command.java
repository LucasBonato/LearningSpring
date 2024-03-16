package com.example.demo.Command;

import org.springframework.http.ResponseEntity;

public interface Command<E, T>{
    ResponseEntity<T> execute(E entity);
}