package com.hhstudygroup.npustudy.service;

import com.hhstudygroup.npustudy.domain.ExamPaper;
import com.hhstudygroup.npustudy.domain.ExamPaperAnswer;
import com.hhstudygroup.npustudy.domain.TaskExamCustomerAnswer;

import java.util.Date;
import java.util.List;

public interface TaskExamCustomerAnswerService extends BaseService<TaskExamCustomerAnswer> {

    void insertOrUpdate(ExamPaper examPaper, ExamPaperAnswer examPaperAnswer, Date now);

    TaskExamCustomerAnswer selectByTUid(Integer tid, Integer uid);

    List<TaskExamCustomerAnswer> selectByTUid(List<Integer> taskIds, Integer uid);
}
