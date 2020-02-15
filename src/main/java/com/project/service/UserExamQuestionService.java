package com.project.service;

import com.project.entity.UserExamQuestion;

public interface UserExamQuestionService {
    UserExamQuestion save(UserExamQuestion question);
    UserExamQuestion findById(Long id);
}
