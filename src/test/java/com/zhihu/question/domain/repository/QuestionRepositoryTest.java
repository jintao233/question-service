package com.zhihu.question.domain.repository;

import com.zhihu.question.core.JpaRepositoryTest;
import com.zhihu.question.domain.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author admin
 */
@JpaRepositoryTest
class QuestionRepositoryTest {

    private final QuestionRepository questionRepository;
    private final EntityManager entityManager;

    @Autowired
    QuestionRepositoryTest(QuestionRepository questionRepository, EntityManager entityManager) {
        this.questionRepository = questionRepository;
        this.entityManager = entityManager;
    }

    @Test
    void repository_should_successful_save_question() {
        var question = new Question("UID_00001", "a title for test", "a detail for test");
        var savedQuestion = questionRepository.save(question);
        assertThat(savedQuestion.getId(), is(notNullValue()));
        assertThat(savedQuestion.equals(question), is(true));
    }

    @Test
    void repository_should_successful_quest_by_id() {
        var question = new Question("UID_00001", "a title for test", "a detail for test");
        var savedQuestion = questionRepository.saveAndFlush(question);
        entityManager.detach(savedQuestion);
        var queryQuestion = questionRepository.findById(savedQuestion.getId())
                .orElseThrow(AssertionError::new);
        assertThat(queryQuestion.equals(savedQuestion), is(true));
    }

}