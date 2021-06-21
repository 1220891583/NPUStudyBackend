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
     * 学科
     */
    private Integer subjectId;
    /**
     * 题目总分(千分制)
     */
    private Integer score;
    /**
     * 级别
     */
    private Integer gradeLevel;
    /**
     * 题目难度
     */
    private Integer difficult;

    /**
     * 正确答案
     */
    private String correct;

    /**
     * 题目 填空、 题干、解析、答案等信息
     */
    private Integer infoTextContentId;

    /**
     * 创建人
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

}
