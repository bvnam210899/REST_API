package com.example.student_manager.services.validators;

import com.example.student_manager.models.in.ClassIn;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ClassEntityValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == ClassIn.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClassIn classIn = (ClassIn) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.ClassEntity.name");
    }
}
