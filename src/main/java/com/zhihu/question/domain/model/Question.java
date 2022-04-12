package com.zhihu.question.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author admin
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String questionerId;
    private String title;
    private String detail;

    public Question(String questionerId, String title, String detail) {
        this.questionerId = questionerId;
        this.title = title;
        this.detail = detail;
    }

    protected Question() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionerId() {
        return questionerId;
    }

    public void setQuestionerId(String questionerId) {
        this.questionerId = questionerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question = (Question) o;
        return questionerId.equals(question.questionerId)
                && title.equals(question.title)
                && Objects.equals(detail, question.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionerId, title, detail);
    }
}
