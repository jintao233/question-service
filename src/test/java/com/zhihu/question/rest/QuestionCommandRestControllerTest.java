package com.zhihu.question.rest;

import com.zhihu.question.domain.application.QuestionApplicationService;
import com.zhihu.question.domain.application.result.QuestionCreatedResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author admin
 * @create 2022/4/12 2:05 下午
 */
@WebMvcTest
class QuestionCommandRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionApplicationService questionApplicationService;

    @Test
    void return_ok_when_create_request() throws Exception {
        String questionId = "TEST_00001";
        given(questionApplicationService.createQuestion(any()))
                .willReturn(new QuestionCreatedResult(questionId));
        var json = new ClassPathResource("request/question/create-question/200-ok.json").getInputStream().readAllBytes();
        mockMvc.perform(post("/questions/create-question")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.questionerId").value(questionId));
    }
}
