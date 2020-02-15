package com.project.service;

import com.project.entity.UserExamQuestion;
import com.project.repository.UserExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExamQuestionServiceImpl implements UserExamQuestionService{

    @Autowired
    private UserExamQuestionRepository examQuestionRepository;

    @Override
    public UserExamQuestion save(UserExamQuestion question) {
        return examQuestionRepository.save(question);
    }

    @Override
    public UserExamQuestion findById(Long id) {
        return examQuestionRepository.findById(id).orElse(null);
    }
}
