package com.project.service;

import com.project.entity.QuestionNormal;
import com.project.repository.QuestionNormalRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionNormalServiceImpl implements QuestionNormalService{

    QuestionNormalRepository questionNormalRepository;

    @Override
    public QuestionNormal save(QuestionNormal questionNormal) {
        return questionNormalRepository.save(questionNormal);
    }
}
