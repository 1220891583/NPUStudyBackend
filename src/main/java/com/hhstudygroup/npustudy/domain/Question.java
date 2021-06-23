package com.hhstudygroup.npustudy.domain;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable {
    /**
     * id: int
     * question_type: int
     * subject_id: int
     * score: int
     * grade_level: int
     * difficult: int
     * correct: text
     * info_text_content_id: int
     * create_user: int
     * status: int
     * create_time: datetime
     * deleted: bit(1)
     */
    private static final long serialVersionUID = -3859162627766724810L;
    private Integer id;
    /**
     * 	1.单选题 2.多选题 3.判断题
     */
    private Integer questionType;
    /**
     * 学科 subjectId
     */
    private Integer subjectId;
    /**
     * 题目总分(千分制) score
     */
    private Integer score;
    /**
     * 级别 gradeLevel
     */
    private Integer gradeLevel;
    /**
     * 题目难度 difficult
     */
    private Integer difficult;

    /**
     * 正确答案 correct
     */
    private String correct;

    /**
     * 题目 填空、 题干、解析、答案等信息 infoTextContentId
     */
    private Integer infoTextContentId;

    /**
     * 创建人 createUser
     */
    private Integer createUser;

    /**
     * 1.正常
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    private Boolean deleted;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public Integer getInfoTextContentId() {
        return infoTextContentId;
    }

    public void setInfoTextContentId(Integer infoTextContentId) {
        this.infoTextContentId = infoTextContentId;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionType=" + questionType +
                ", subjectId=" + subjectId +
                ", score=" + score +
                ", gradeLevel=" + gradeLevel +
                ", difficult=" + difficult +
                ", correct='" + correct + '\'' +
                ", infoTextContentId=" + infoTextContentId +
                ", createUser=" + createUser +
                ", status=" + status +
                ", createTime=" + createTime +
                ", deleted=" + deleted +
                '}';
    }
}
