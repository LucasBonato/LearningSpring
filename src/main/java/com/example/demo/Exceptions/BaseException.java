package com.example.demo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class BaseException extends RuntimeException{
    private HttpStatus status;
    private ExceptionResponse exceptionResponse;
}
