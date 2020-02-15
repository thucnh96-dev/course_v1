package com.project.repository;

import com.project.entity.UserExamQuestionNormalAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExamQuestionNormalAnswerRepository extends JpaRepository<UserExamQuestionNormalAnswer,Long> {
}
