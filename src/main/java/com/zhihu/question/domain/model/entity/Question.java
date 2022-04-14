package com.zhihu.question.domain.model.entity;

import com.zhihu.question.domain.model.vo.QuestionUpdatedRecord;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author admin
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String questionerId;
    private String title;
    private String detail;

    @ElementCollection
    @OrderBy("updatedAt")
    @CollectionTable(name = "question_updated_record")
    private List<QuestionUpdatedRecord> updatedRecords;

    @PersistenceConstructor
    protected Question() {
    }

    public Question(String questionerId, String title, String detail) {
        this.questionerId = questionerId;
        this.title = title;
        this.detail = detail;
        this.updatedRecords = new ArrayList<>();
        updatedRecords.add(QuestionUpdatedRecord.ofCreated(questionerId, title, detail));
    }

    public void editTitle(String editorId, String editTitle, String reason) {
        this.updatedRecords.add(QuestionUpdatedRecord.ofTitleEdited(editorId, editTitle, title, reason));
        this.title = editTitle;
    }

    public void editDetail(String editorId, String editDetail, String reason) {
        this.updatedRecords.add(QuestionUpdatedRecord.ofDetailEdited(editorId, editDetail, detail, reason));
        this.detail = editDetail;
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

    public List<QuestionUpdatedRecord> getUpdatedRecords() {
        return Collections.unmodifiableList(updatedRecords);
    }

    public void setUpdatedRecords(List<QuestionUpdatedRecord> updatedRecords) {
        this.updatedRecords = updatedRecords;
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

        if (!(Objects.equals(id, question.id)
                && Objects.equals(questionerId, question.questionerId)
                && Objects.equals(title, question.title)
                && Objects.equals(detail, question.detail))) {
            return false;
        }
        if (updatedRecords.size() != question.updatedRecords.size()) {
            return false;
        }
        for (int i = 0; i < updatedRecords.size(); i++) {
            if (!Objects.equals(updatedRecords.get(i), question.updatedRecords.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionerId, title, detail);
    }

    @Override
    public String toString() {
        return "Question{"
                + "id=" + id
                + ", questionerId='" + questionerId + '\''
                + ", title='" + title + '\''
                + ", detail='" + detail + '\''
                + ", updatedRecords=" + updatedRecords
                + '}';
    }
}


