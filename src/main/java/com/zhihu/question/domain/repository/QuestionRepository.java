package com.zhihu.question.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhihu.question.domain.model.entity.Question;

/**
 * @author admin
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {}
