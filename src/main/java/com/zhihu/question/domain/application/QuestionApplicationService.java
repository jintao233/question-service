package com.zhihu.question.domain.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhihu.question.domain.application.command.CreateQuestionCommand;
import com.zhihu.question.domain.application.result.QuestionCreatedResult;
import com.zhihu.question.domain.model.entity.Question;
import com.zhihu.question.domain.repository.QuestionRepository;

/**
 * @author admin
 */
@Service
public class QuestionApplicationService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionApplicationService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public QuestionCreatedResult createQuestion(CreateQuestionCommand command) {
        var question = new Question(command.questionerId(), command.title(), command.detail());
        questionRepository.save(question);
        return new QuestionCreatedResult(question.getQuestionerId());
    }
}
