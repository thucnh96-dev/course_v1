package com.project.service;

import com.project.entity.QuestionNormal;
import com.project.repository.QuestionNormalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionNormalServiceImpl implements QuestionNormalService{

    @Autowired
    QuestionNormalRepository questionNormalRepository;

    @Override
    public QuestionNormal save(QuestionNormal questionNormal) {
        return questionNormalRepository.save(questionNormal);
    }
}
