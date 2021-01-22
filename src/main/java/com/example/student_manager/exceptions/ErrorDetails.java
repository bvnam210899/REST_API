package com.example.student_manager.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
    private HttpStatus httpStatus;

    private String message;

    public ErrorDetails(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ErrorDetails() {
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
