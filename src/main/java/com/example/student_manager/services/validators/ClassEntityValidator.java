package com.example.student_manager.services.validators;

import com.example.student_manager.exceptions.Response;
import com.example.student_manager.exceptions.ResponseDetail;
import com.example.student_manager.models.in.ClassIn;
import com.example.student_manager.untils.StringResponses;
import org.springframework.http.ResponseEntity;

public class ClassEntityValidator {
    public static<T> ResponseEntity<ResponseDetail<T>> validateClass(ClassIn classIn) {
        if(classIn.getName() == null)
            return Response.badRequest(StringResponses.NAME_IS_NULL);

        String NAME_REGEX = "^[a-zA-Z]{0,40}$";
        if (!classIn.getName().matches(NAME_REGEX))
            return Response.badRequest(StringResponses.NAME_NOT_VALID);

        return Response.ok();
    }
}
