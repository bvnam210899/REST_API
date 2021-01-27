package com.example.student_manager.exceptions;

import com.example.student_manager.untils.StringResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    public static<T> ResponseEntity<ResponseDetail<T>> ok(T object) {
        return ResponseEntity
                .status(200)
                .body(new ResponseDetail<>(HttpStatus.OK, StringResponses.SUCCESS, object));
    }
    public static<T> ResponseEntity<ResponseDetail<T>> ok() {
        return ResponseEntity
                .ok()
                .body(new ResponseDetail<>(HttpStatus.OK, StringResponses.SUCCESS));
    }

    public static<T> ResponseEntity<ResponseDetail<T>> badRequest() {
        return ResponseEntity
                .badRequest()
                .body(new ResponseDetail<>(HttpStatus.BAD_REQUEST, StringResponses.ID_NOT_VALID));
    }

    public static<T> ResponseEntity<ResponseDetail<T>> badRequest(String message) {
        return ResponseEntity
                .badRequest()
                .body(new ResponseDetail<T>(HttpStatus.BAD_REQUEST, message));
    }

    public static<T> ResponseEntity<ResponseDetail<T>> badRequest(String message, T object) {
        return ResponseEntity
                .badRequest()
                .body(new ResponseDetail<T>(HttpStatus.BAD_REQUEST, message, object));
    }
}
