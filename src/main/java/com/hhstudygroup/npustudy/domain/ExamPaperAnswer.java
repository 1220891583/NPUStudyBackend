package com.hhstudygroup.npustudy.domain;

import java.io.Serializable;
import java.util.Date;

public class ExamPaperAnswer implements Serializable {
    /**
     * id: int
     * exam_paper_id: int
     * system_score: int
     * user_score: int
     * paper_score: int
     * question_correct: int
     * question_count: int
     * do_time: int
     * status: int
     * create_user: int
     * create_time: datetime
     * task_exam_id: int
     */

    private static final long serialVersionUID = -447501431437432304L;

    private Integer id;

    private Integer examPaperId;

    /**
     * 最终得分(千分制)
     */
    private Integer userScore;

    /**
     * 试卷总分
     */
    private Integer paperScore;

    /**
     * 做对题目数量
     */
    private Integer questionCorrect;

    /**
     * 题目总数量
     */
    private Integer questionCount;

    /**
     * 做题时间(秒)
     */
    private Integer doTime;

    /**
     * 试卷状态(1待判分 2完成)
     */
    private Integer status;

    /**
     * 学生
     */
    private Integer createUser;

    /**
     * 提交时间
     */
    private Date createTime;

    private Integer taskExamId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(Integer examPaperId) {
        this.examPaperId = examPaperId;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public Integer getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(Integer paperScore) {
        this.paperScore = paperScore;
    }

    public Integer getQuestionCorrect() {
        return questionCorrect;
    }

    public void setQuestionCorrect(Integer questionCorrect) {
        this.questionCorrect = questionCorrect;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public Integer getDoTime() {
        return doTime;
    }

    public void setDoTime(Integer doTime) {
        this.doTime = doTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTaskExamId() {
        return taskExamId;
    }

    public void setTaskExamId(Integer taskExamId) {
        this.taskExamId = taskExamId;
    }

    @Override
    public String toString() {
        return "ExamPaperAnswer{" +
                "id=" + id +
                ", examPaperId=" + examPaperId +
                ", userScore=" + userScore +
                ", paperScore=" + paperScore +
                ", questionCorrect=" + questionCorrect +
                ", questionCount=" + questionCount +
                ", doTime=" + doTime +
                ", status=" + status +
                ", createUser=" + createUser +
                ", createTime=" + createTime +
                ", taskExamId=" + taskExamId +
                '}';
    }
}
