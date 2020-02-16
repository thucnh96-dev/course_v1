package com.project.service;

import com.project.entity.Question;
import com.project.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> save(List<Question> question) {
        return questionRepository.saveAll(question);
    }

    @Override
    public Question findById(Long Id) {
        return questionRepository.findById(Id).orElse(null);
    }

    @Override
    public Page<Question> findAll(Specification<Question> spec, Pageable pageable) {
        return questionRepository.findAll(spec,pageable);
    }
}
