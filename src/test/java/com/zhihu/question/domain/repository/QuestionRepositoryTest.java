package com.zhihu.question.domain.repository;

import com.zhihu.question.core.JpaRepositoryTest;
import com.zhihu.question.domain.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@JpaRepositoryTest
class QuestionRepositoryTest {

    private final QuestionRepository questionRepository;

    @Autowired
    QuestionRepositoryTest(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Test
    void repository_should_successful_save_question() {
        var question = new Question("UID_00001",
                "a title for test", "a detail for test");
        var savedQuestion = questionRepository.save(question);
        assertThat(savedQuestion.getId(), is(notNullValue()));
        assertThat(savedQuestion.getQuestionerId(), equalTo(question.getQuestionerId()));
        assertThat(savedQuestion.getTitle(), equalTo(question.getTitle()));
        assertThat(savedQuestion.getDetail(), equalTo(question.getDetail()));
    }

}