package com.example.student_manager.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorDetails <T> {
    private HttpStatus httpStatus;

    private String message;

    private T data;

    public ErrorDetails(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ErrorDetails(HttpStatus httpStatus, String message, T data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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
