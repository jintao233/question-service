package com.zhihu.question.domain.repository;

import com.zhihu.question.domain.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author admin
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
