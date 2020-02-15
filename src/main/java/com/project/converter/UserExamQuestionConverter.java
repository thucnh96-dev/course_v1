package com.project.converter;

import com.project.entity.UserExamQuestion;
import org.springframework.stereotype.Component;

@Component("userExamQuestionConverter")
public class UserExamQuestionConverter extends AbstractConverter<Object , UserExamQuestion> {
    @Override
    public UserExamQuestion convert(Object o) throws Exception {
        return null;
    }
}
