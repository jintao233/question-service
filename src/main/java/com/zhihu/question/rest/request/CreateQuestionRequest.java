package com.zhihu.question.rest.request;

/**
 * @author admin
 * @create 2022/4/12 1:56 下午
 */
public record CreateQuestionRequest(String questionerId, String title, String detail) {
}
