package com.example.student_manager.services.validators;

import com.example.student_manager.exceptions.ErrorDetails;
import com.example.student_manager.models.in.ClassIn;
import com.example.student_manager.untils.StringResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ClassEntityValidator {
    public ResponseEntity<?> validateClass(ClassIn classIn) {
        if(classIn.getName() == null){
            return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST, StringResponses.NAME_IS_NULL), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
