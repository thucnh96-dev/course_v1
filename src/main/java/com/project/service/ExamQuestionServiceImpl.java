package com.project.service;

import com.project.entity.ExamQuestion;
import com.project.repository.ExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService{

    @Autowired
    private ExamQuestionRepository examQuestionRepository;

    @Override
    public ExamQuestion findById(Long id) {
        return examQuestionRepository.findById(id).orElse(null);
    }

    @Override
    public ExamQuestion save(ExamQuestion examQuestion) {
        return examQuestionRepository.save(examQuestion);
    }
}
