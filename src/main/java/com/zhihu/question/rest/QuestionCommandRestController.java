package com.zhihu.question.rest;

import com.zhihu.question.domain.application.QuestionApplicationService;
import com.zhihu.question.domain.application.command.CreateQuestionCommand;
import com.zhihu.question.rest.request.CreateQuestionRequest;
import com.zhihu.question.rest.response.CreateQuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @create 2022/4/12 1:52 下午
 */
@RestController
@RequestMapping("/questions")
public class QuestionCommandRestController {

    private final QuestionApplicationService questionService;

    @Autowired
    public QuestionCommandRestController(QuestionApplicationService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/create-question")
    public CreateQuestionResponse createQuestion(@RequestBody CreateQuestionRequest request) {
        var command = new CreateQuestionCommand(request.questionerId(), request.title(), request.detail());
        var result = questionService.createQuestion(command);
        return new CreateQuestionResponse(result.questionerId());
    }
}
