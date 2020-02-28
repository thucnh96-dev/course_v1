package com.project.service;

import com.project.entity.ExamQuestion;
import com.project.repository.ExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ExamQuestion> saveAll(List<ExamQuestion> examQuestions) {
        return examQuestionRepository.saveAll(examQuestions);
    }
}
