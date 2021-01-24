package com.example.student_manager.services.validators;

import com.example.student_manager.exceptions.ErrorDetails;
import com.example.student_manager.models.in.StudentIn;
import com.example.student_manager.untils.StringResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StudentInValidator {

    public ResponseEntity<?> validateStudent(StudentIn studentIn) {
        String NAME_REGEX = "^[a-zA-Z]{0,40}$";
        if (studentIn.getName() == null || !studentIn.getName().matches(NAME_REGEX))
            return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST, StringResponses.NAME_IS_NULL), HttpStatus.BAD_REQUEST);

        if (studentIn.getBirthday() == null)
            return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST, StringResponses.BIRTHDAY_IS_NULL), HttpStatus.BAD_REQUEST);

        if (studentIn.getAddress() == null)
            return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST, StringResponses.ADDRESS_IS_NULL), HttpStatus.BAD_REQUEST);

        String PHONE_REGEX = "(09|03|08|05)+([0-9]{8})\\b";
        if (studentIn.getPhone_number() == null || !studentIn.getPhone_number().matches(PHONE_REGEX))
            return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST, StringResponses.PHONE_NUMBER_IS_NULL), HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(HttpStatus.OK);
    }


}
