package com.hhstudygroup.npustudy.service;

import com.hhstudygroup.npustudy.domain.ExamPaper;
import com.hhstudygroup.npustudy.domain.User;
import com.hhstudygroup.npustudy.viewmodel.admin.exam.ExamPaperEditRequestVM;
import com.hhstudygroup.npustudy.viewmodel.admin.exam.ExamPaperPageRequestVM;
import com.hhstudygroup.npustudy.viewmodel.student.dashboard.PaperFilter;
import com.hhstudygroup.npustudy.viewmodel.student.dashboard.PaperInfo;
import com.hhstudygroup.npustudy.viewmodel.student.exam.ExamPaperPageVM;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ExamPaperService extends BaseService<ExamPaper> {

    PageInfo<ExamPaper> page(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> taskExamPage(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> studentPage(ExamPaperPageVM requestVM);

    ExamPaper savePaperFromVM(ExamPaperEditRequestVM examPaperEditRequestVM, User user);

    ExamPaperEditRequestVM examPaperToVM(Integer id);

    List<PaperInfo> indexPaper(PaperFilter paperFilter);

    Integer selectAllCount();

    List<Integer> selectMothCount();
}
