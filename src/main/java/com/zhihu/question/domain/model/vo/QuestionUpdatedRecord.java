package com.zhihu.question.domain.model.vo;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.zhihu.question.domain.model.vo.QuestionUpdatedRecord.UpdateType.CREATED;
import static com.zhihu.question.domain.model.vo.QuestionUpdatedRecord.UpdateType.DETAIL_EDIT;
import static com.zhihu.question.domain.model.vo.QuestionUpdatedRecord.UpdateType.TITLE_EDIT;

/**
 * @author admin
 * @create 2022/4/13 1:42 上午
 */
@Embeddable
public class QuestionUpdatedRecord {

    @Enumerated(EnumType.STRING)
    private UpdateType updateType;

    private String updaterId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    private String reason;
    private String createTitle;
    private String createDetail;

    private String editedTitle;
    private String unEditedTitle;
    private String editedDetail;
    private String unEditedDetail;

    private QuestionUpdatedRecord(UpdateType updateType, String updaterId,
                                  LocalDateTime updatedAt, String reason,
                                  String createTitle, String createDetail,
                                  String editedTitle, String unEditedTitle,
                                  String editedDetail, String unEditedDetail) {
        this.updateType = updateType;
        this.updaterId = updaterId;
        this.updatedAt = updatedAt;
        this.reason = reason;
        this.createTitle = createTitle;
        this.createDetail = createDetail;
        this.editedTitle = editedTitle;
        this.unEditedTitle = unEditedTitle;
        this.editedDetail = editedDetail;
        this.unEditedDetail = unEditedDetail;
    }

    @PersistenceConstructor
    protected QuestionUpdatedRecord() {
    }

    /**
     * 创建问题时的记录信息
     *
     * @param updaterId    问题的创建人
     * @param createTitle  问题的标题
     * @param createDetail 问题的详情
     * @return 创建问题时的记录对象
     */
    public static QuestionUpdatedRecord ofCreated(String updaterId, String createTitle, String createDetail) {
        return new QuestionUpdatedRecord(CREATED, updaterId, LocalDateTime.now(), null, createTitle,
                createDetail, null, null, null, null);
    }

    /**
     * 更新问题的标题时的记录
     *
     * @param updaterId     更新人
     * @param editedTitle   更新后的标题
     * @param unEditedTitle 更新前的标题
     * @param reason        更新的原因
     * @return 更新问题标题时的问题记录
     */
    public static QuestionUpdatedRecord ofTitleEdited(String updaterId, String editedTitle, String unEditedTitle, String reason) {
        return new QuestionUpdatedRecord(TITLE_EDIT, updaterId, LocalDateTime.now(), reason, null,
                null, editedTitle, unEditedTitle, null, null);
    }

    /**
     * 更新问题的详情时的记录
     *
     * @param updaterId      更新人
     * @param editedDetail   更新后的标题
     * @param unEditedDetail 更新前的标题
     * @param reason         更新的原因
     * @return 更新问题详情时的问题记录
     */
    public static QuestionUpdatedRecord ofDetailEdited(String updaterId, String editedDetail, String unEditedDetail, String reason) {
        return new QuestionUpdatedRecord(DETAIL_EDIT, updaterId, LocalDateTime.now(), reason, null,
                null, null, null, editedDetail, unEditedDetail);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QuestionUpdatedRecord that = (QuestionUpdatedRecord) o;
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return updateType == that.updateType
                && Objects.equals(updaterId, that.updaterId)
                && updatedAt.format(formatter).equals(that.updatedAt.format(formatter))
                && Objects.equals(reason, that.reason)
                && Objects.equals(createTitle, that.createTitle)
                && Objects.equals(createDetail, that.createDetail)
                && Objects.equals(editedTitle, that.editedTitle)
                && Objects.equals(unEditedTitle, that.unEditedTitle)
                && Objects.equals(editedDetail, that.editedDetail)
                && Objects.equals(unEditedDetail, that.unEditedDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updateType, updaterId, reason, createTitle, createDetail,
                editedTitle, unEditedTitle, editedDetail, unEditedDetail);
    }

    @Override
    public String toString() {
        return "QuestionUpdatedRecord{"
                + "updateType=" + updateType
                + ", updaterId='" + updaterId + '\''
                + ", updatedAt=" + updatedAt
                + ", reason='" + reason + '\''
                + ", createTitle='" + createTitle + '\''
                + ", createDetail='" + createDetail + '\''
                + ", editedTitle='" + editedTitle + '\''
                + ", unEditedTitle='" + unEditedTitle + '\''
                + ", editedDetail='" + editedDetail + '\''
                + ", unEditedDetail='" + unEditedDetail + '\''
                + '}';
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreateTitle() {
        return createTitle;
    }

    public void setCreateTitle(String createTitle) {
        this.createTitle = createTitle;
    }

    public String getCreateDetail() {
        return createDetail;
    }

    public void setCreateDetail(String createDetail) {
        this.createDetail = createDetail;
    }

    public String getEditedTitle() {
        return editedTitle;
    }

    public void setEditedTitle(String editedTitle) {
        this.editedTitle = editedTitle;
    }

    public String getUnEditedTitle() {
        return unEditedTitle;
    }

    public void setUnEditedTitle(String unEditedTitle) {
        this.unEditedTitle = unEditedTitle;
    }

    public String getEditedDetail() {
        return editedDetail;
    }

    public void setEditedDetail(String editedDetail) {
        this.editedDetail = editedDetail;
    }

    public String getUnEditedDetail() {
        return unEditedDetail;
    }

    public void setUnEditedDetail(String unEditedDetail) {
        this.unEditedDetail = unEditedDetail;
    }

    /**
     * 编辑类型
     */
    public enum UpdateType {
        // 创建问题
        CREATED,
        // 编辑问题（title and detail）
        QUESTION_EDIT,
        // 编辑问题标题
        TITLE_EDIT,
        // 编辑问题详情
        DETAIL_EDIT;
    }
}
