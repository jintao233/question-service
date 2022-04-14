package com.zhihu.question.domain.application.command;

/**
 * @author admin
 * @create 2022/4/12 1:32 下午
 */
public record CreateQuestionCommand(String questionerId, String title, String detail) {
}
