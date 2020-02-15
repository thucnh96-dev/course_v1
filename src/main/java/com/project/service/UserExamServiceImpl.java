package com.project.service;

import com.project.entity.User;
import com.project.entity.UserExam;
import com.project.entity.UserExamQuestion;
import com.project.repository.UserExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserExamServiceImpl implements UserExamService{

    @Autowired
    private UserExamRepository userExamRepository;

    @Override
    public UserExam findById(Long id) {
        return userExamRepository.findById(id).orElse(null);
    }

    @Override
    public UserExam save(UserExam userExam) {
        return userExamRepository.save(userExam);
    }

    @Override
    public List<UserExam> findAllByUserAndExamIsNotNullAndDeleteAtIsNull(User user) {
        return userExamRepository.findAllByUserAndExamIsNotNullAndDeleteAtIsNull(user);
    }
}
