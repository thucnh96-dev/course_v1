package com.project.service;

import com.project.entity.Exam;
import com.project.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ExamService {
    Exam findbyId(Long id);

    List<Exam> findAllByUserAndDeleteAtIsNull(User user);

    Exam findByIdAndDeleteAtIsNull(Long id);

    Page<Exam> findAll(Specification<Exam> spec , Pageable pageable);
}
