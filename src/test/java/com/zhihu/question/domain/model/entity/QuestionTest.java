package com.zhihu.question.domain.model.entity;

import com.zhihu.question.domain.model.vo.QuestionUpdatedRecord;
import org.junit.jupiter.api.Test;
import static com.zhihu.question.domain.model.vo.QuestionUpdatedRecord.UpdateType.CREATED;
import static org.testcontainers.shaded.org.hamcrest.MatcherAssert.assertThat;
import static org.testcontainers.shaded.org.hamcrest.Matchers.hasSize;
import static org.testcontainers.shaded.org.hamcrest.Matchers.is;

/**
 * @author admin
 * @create 2022/4/13 10:52 下午
 */
class QuestionTest {

    @Test
    void should_generate_created_record_after_question_created() {
        var questionerId = "UID_00001";
        var title = "a title for test";
        var detail = "a detail for test";
        var question = new Question(questionerId, title, detail);
        var updatedRecords = question.getUpdatedRecords();
        assertThat(updatedRecords, hasSize(1));
        var record = updatedRecords.get(0);
        assertThat(record.getUpdateType(), is(CREATED));
        assertThat(record.getCreateTitle(), is(title));
        assertThat(record.getCreateDetail(), is(detail));
    }

    @Test
    void should_generate_title_edited_record_after_question_title_edited() {
        var questionerId = "UID_00001";
        var title = "a title for test";
        var detail = "a detail for test";
        var editedTitle = "a new title for test";
        var editedDetail = "a new detail for test";
        var editedTitleReason = "for test editedTitle";
        var editedDetailReason = "for test editedDetailR";
        var question = new Question(questionerId, title, detail);
        question.editTitle("UID_00002", editedTitle, editedTitleReason);
        question.editDetail("UID_00003", editedDetail, editedDetailReason);
        var updatedRecords = question.getUpdatedRecords();
        assertThat(updatedRecords, hasSize(3));

        var record = updatedRecords.get(0);
        assertThat(record.getUpdateType(), is(CREATED));
        assertThat(record.getCreateTitle(), is(title));
        assertThat(record.getCreateDetail(), is(detail));

        var editTitleRecord = updatedRecords.get(1);
        assertThat(editTitleRecord.getUpdateType(), is(QuestionUpdatedRecord.UpdateType.TITLE_EDIT));
        assertThat(editTitleRecord.getEditedTitle(), is(editedTitle));
        assertThat(editTitleRecord.getUnEditedTitle(), is(title));

        var editDetailRecord = updatedRecords.get(2);
        assertThat(editDetailRecord.getUpdateType(), is(QuestionUpdatedRecord.UpdateType.DETAIL_EDIT));
        assertThat(editDetailRecord.getEditedDetail(), is(editedDetail));
        assertThat(editDetailRecord.getUnEditedDetail(), is(detail));

        assertThat(question.getTitle(), is(editedTitle));
        assertThat(question.getDetail(), is(editedDetail));
    }

}