package com.project.service;

import com.project.entity.User;
import com.project.entity.UserExam;
import com.project.entity.UserExamQuestion;

import java.util.List;

public interface UserExamService {

    UserExam findById(Long id);
    UserExam save(UserExam userExam);
    List<UserExam> findAllByUserAndExamIsNotNullAndDeleteAtIsNull(User user);

}
