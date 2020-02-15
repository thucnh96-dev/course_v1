package com.project.service;

import com.project.entity.ExamQuestion;

public interface ExamQuestionService {
    ExamQuestion findById(Long id);
    ExamQuestion save(ExamQuestion examQuestion);

}
