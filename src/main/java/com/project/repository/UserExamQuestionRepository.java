package com.project.repository;

import com.project.entity.UserExamQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExamQuestionRepository extends JpaRepository<UserExamQuestion,Long> {
}
