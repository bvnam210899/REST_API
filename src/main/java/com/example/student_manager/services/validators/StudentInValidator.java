package com.example.student_manager.services.validators;

import com.example.student_manager.exceptions.EmptyException;
import com.example.student_manager.models.in.StudentIn;

public class StudentInValidator {
    private final String NAME_REGEX = "^[a-zA-Z]{0,40}$";
    private final String PHONE_REGEX = "(09|03|08|05)+([0-9]{8})\\b";
//    private final String DATE_REGEX = "^[1-2]{1}[0-9]{3}-[0-1]{1}[1-2]{1}-[0-3]{1}[0-9]{1}$";

    public void NullStudent(StudentIn studentIn) throws EmptyException {
        if (studentIn.getName() == null || studentIn.getName().matches(NAME_REGEX)) {
            throw new EmptyException("name is null or not valid");
        }
        if (studentIn.getBirthday() == null) {
            throw new EmptyException("birthday is null");
        }
        if (studentIn.getAddress() == null) {
            throw new EmptyException("address is null");
        }
        if (studentIn.getPhone_number() == null || studentIn.getPhone_number().matches(PHONE_REGEX)) {
            throw new EmptyException("phone number is null or not valid");
        }
    }


}
