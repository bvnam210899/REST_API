package com.example.student_manager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomException {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerNotFoundException(NotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<?> handlerEmptyException(EmptyException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NO_CONTENT, ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NullException.class)
    public ResponseEntity<?> handlerNullException(NullException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NO_CONTENT, ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerAllException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

