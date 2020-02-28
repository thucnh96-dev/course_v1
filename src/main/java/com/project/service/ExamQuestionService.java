package com.project.service;

import com.project.entity.ExamQuestion;

import java.util.List;

public interface ExamQuestionService {
    ExamQuestion findById(Long id);

    ExamQuestion save(ExamQuestion examQuestion);

    List<ExamQuestion> saveAll(List<ExamQuestion> examQuestions);

}
