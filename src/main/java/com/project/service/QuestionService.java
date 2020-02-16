package com.project.service;


import com.project.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface QuestionService {

    Question save(Question question);

    List<Question> save(List<Question> question);

    Question findById(Long Id);

    Page<Question> findAll(Specification<Question> spec , Pageable pageable);



}
