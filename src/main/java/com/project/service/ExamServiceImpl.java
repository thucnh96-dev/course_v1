package com.project.service;

import com.project.entity.Exam;
import com.project.entity.User;
import com.project.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService{

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam findbyId(Long id) {
        return examRepository.findById(id).orElse(null);
    }

    @Override
    public Exam findByName(String name) {
        return examRepository.findByTitleIsAndDeleteAtIsNull(name);
    }

    @Override
    public List<Exam> findAllByUserAndDeleteAtIsNull(User user) {
        return examRepository.findAllByUserAndDeleteAtIsNull(user);
    }

    @Override
    public Exam findByIdAndDeleteAtIsNull(Long id) {
        return examRepository.findByIdAndDeleteAtIsNull(id);
    }

    @Override
    public Page<Exam> findAll(Specification<Exam> spec, Pageable pageable) {
        return examRepository.findAll(spec,pageable);
    }

    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }
}
