package com.project.repository;

import com.project.entity.QuestionNormal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionNormalRepository extends JpaRepository<QuestionNormal,Long> {
}
