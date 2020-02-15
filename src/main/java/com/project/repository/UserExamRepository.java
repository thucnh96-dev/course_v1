package com.project.repository;

import com.project.entity.User;
import com.project.entity.UserExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExamRepository extends JpaRepository<UserExam,Long> {

    List<UserExam> findAllByUserAndExamIsNotNullAndDeleteAtIsNull(User user);



}
