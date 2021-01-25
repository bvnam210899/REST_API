package com.example.student_manager.exceptions;

import com.example.student_manager.untils.StringResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    public static ResponseEntity<ResponseDetail<Object>> ok(Object object) {
        ResponseDetail<Object> responseDetail = new ResponseDetail<>(HttpStatus.OK, StringResponses.SUCCESS, object);
        return ResponseEntity.ok().body(responseDetail);
    }
    public static ResponseEntity<ResponseDetail<Object>> ok() {
        ResponseDetail<Object> responseDetail = new ResponseDetail<>(HttpStatus.OK, StringResponses.SUCCESS);
        return ResponseEntity.ok().body(responseDetail);
    }

    public static ResponseEntity<ResponseDetail<Object>> badRequest(String message) {
        ResponseDetail<Object> responseDetail = new ResponseDetail<>(HttpStatus.BAD_REQUEST, message);
        return ResponseEntity.badRequest().body(responseDetail);
    }

    public static ResponseEntity<ResponseDetail<Object>> badRequest(Object object) {
        ResponseDetail<Object> responseDetail = new ResponseDetail<>(HttpStatus.BAD_REQUEST, StringResponses.ID_NOT_VALID, object);
        return ResponseEntity.ok().body(responseDetail);
    }

}
