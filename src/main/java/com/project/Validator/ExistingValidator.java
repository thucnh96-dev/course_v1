package com.project.Validator;

import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.util.Assert.isTrue;

@Component("existingValidator")
public class ExistingValidator {

    public void validate(Object object, String objectName) throws IllegalArgumentException {
        isTrue(object == null, "이미 존재하는 " + objectName);
    }


    public void validateNotExist(Object object, String objectName) throws IllegalArgumentException {
        isTrue(object != null, objectName + " 는 존재하지 않습니다");
    }
    public void validateList(Object object, String objectName) throws IllegalArgumentException {
        isTrue((object == null || (object != null && ((List)object).size() == 0)), "이미 존재하는 " + objectName);
    }

    public void validateArrays(Object object, String objectName) throws IllegalArgumentException {
        isTrue((object == null || ((List)object).size() != 0), "이미 존재하는 " + objectName);
    }


    public void validateNullOrEmpty(Object object, String objectName) throws IllegalArgumentException {
        isTrue((object != null), objectName + " 비워둘 수 없습니다");
        if(object != null) {
            isTrue((!"0".equals(object.toString()) && !"".equals(object.toString()) ), objectName + " 비워둘 수 없습니다");
        }
    }
}
