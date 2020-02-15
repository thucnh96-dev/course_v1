package com.project.repository;

import com.project.entity.Exam;
import com.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long>, JpaSpecificationExecutor<Exam> {
    List<Exam> findAllByUserAndDeleteAtIsNull(User user);
    Exam findByIdAndDeleteAtIsNull(Long id);
}
