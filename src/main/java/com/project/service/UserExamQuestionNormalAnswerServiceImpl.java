package com.project.service;

import com.project.entity.UserExamQuestionNormalAnswer;
import com.project.repository.UserExamQuestionNormalAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExamQuestionNormalAnswerServiceImpl implements UserExamQuestionNormalAnswerService{

    @Autowired
    private UserExamQuestionNormalAnswerRepository examQuestionNormalAnswerRepository;

    @Override
    public UserExamQuestionNormalAnswer save(UserExamQuestionNormalAnswer userExamQuestionNormalAnswer) {
        return examQuestionNormalAnswerRepository.save(userExamQuestionNormalAnswer);
    }
}
