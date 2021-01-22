package com.example.student_manager.services.validators;

import com.example.student_manager.exceptions.EmptyException;
import com.example.student_manager.models.in.ClassIn;

public class ClassEntityValidator {
    public void NullClass(ClassIn classIn) throws EmptyException {
        if(classIn.getName() == null){
            throw new EmptyException("name is null");
        }
    }
}
