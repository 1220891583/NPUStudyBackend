package com.hhstudygroup.npustudy.service;

import com.hhstudygroup.npustudy.domain.TaskExam;
import com.hhstudygroup.npustudy.domain.User;
import com.hhstudygroup.npustudy.viewmodel.admin.task.TaskPageRequestVM;
import com.hhstudygroup.npustudy.viewmodel.admin.task.TaskRequestVM;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TaskExamService extends BaseService<TaskExam> {

    PageInfo<TaskExam> page(TaskPageRequestVM requestVM);

    void edit(TaskRequestVM model, User user);

    TaskRequestVM taskExamToVM(Integer id);

    List<TaskExam> getByGradeLevel(Integer gradeLevel);
}
