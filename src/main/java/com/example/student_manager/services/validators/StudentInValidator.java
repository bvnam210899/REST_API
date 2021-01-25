package com.example.student_manager.services.validators;

import com.example.student_manager.exceptions.Response;
import com.example.student_manager.models.in.StudentIn;
import com.example.student_manager.untils.StringResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StudentInValidator {

    public static ResponseEntity<?> validateStudent(StudentIn studentIn) {
        if (studentIn.getName() == null)
            return Response.badRequest(StringResponses.NAME_IS_NULL);

        String NAME_REGEX = "^[a-zA-Z]{0,40}$";
        if (!studentIn.getName().matches(NAME_REGEX))
            return Response.badRequest(StringResponses.NAME_NOT_VALID);

        if (studentIn.getBirthday() == null)
            return Response.badRequest(StringResponses.BIRTHDAY_IS_NULL);

        if (studentIn.getAddress() == null)
            return Response.badRequest(StringResponses.ADDRESS_IS_NULL);

        if (studentIn.getPhone_number() == null)
            return Response.badRequest(StringResponses.PHONE_NUMBER_IS_NULL);

        String PHONE_REGEX = "(09|03|08|05)+([0-9]{8})\\b";
        if (!studentIn.getPhone_number().matches(PHONE_REGEX))
            return Response.badRequest(StringResponses.PHONE_NUMBER_NOT_VALID);

        return ResponseEntity.ok(HttpStatus.OK);
    }


}
