package com.example.student_manager.services.validators;

import com.example.student_manager.exceptions.EmptyException;
import com.example.student_manager.models.in.StudentIn;

public class StudentInValidator {
    private final String NAME_REGEX ="^[a-zA-Z]{0,40}$";
    private final String PHONE_REGEX = "(09|03|08|05)+([0-9]{8})\\b";
    private final String DATE_REGEX = "^[1-2]{1}[0-9]{3}-[0-1]{1}[1-2]{1}-[0-3]{1}[0-9]{1}$";

    public void NullStudent(StudentIn studentIn) throws Exception {
        if(studentIn.getName().isEmpty()) {
            throw new EmptyException("name is empty");
        }
        if(studentIn.getBirthday().equals("")){
            throw new EmptyException("birthday is empty");
        }
        if(studentIn.getAddress().isEmpty()){
            throw new EmptyException("address is empty");
        }
        if(studentIn.getPhone_number().isEmpty()){
            throw new EmptyException("phone number is empty");
        }
    }


}
