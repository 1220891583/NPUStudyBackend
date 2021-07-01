package com.hhstudygroup.npustudy.controller.student;

import com.hhstudygroup.npustudy.base.BaseApiController;
import com.hhstudygroup.npustudy.base.RestResponse;
import com.hhstudygroup.npustudy.domain.ExamPaperQuestionCustomerAnswer;
import com.hhstudygroup.npustudy.domain.Subject;
import com.hhstudygroup.npustudy.domain.TextContent;
import com.hhstudygroup.npustudy.domain.question.QuestionObject;
import com.hhstudygroup.npustudy.service.ExamPaperQuestionCustomerAnswerService;
import com.hhstudygroup.npustudy.service.QuestionService;
import com.hhstudygroup.npustudy.service.SubjectService;
import com.hhstudygroup.npustudy.service.TextContentService;
import com.hhstudygroup.npustudy.utility.DateTimeUtil;
import com.hhstudygroup.npustudy.utility.HtmlUtil;
import com.hhstudygroup.npustudy.utility.JsonUtil;
import com.hhstudygroup.npustudy.utility.PageInfoHelper;
import com.hhstudygroup.npustudy.viewmodel.admin.question.QuestionEditRequestVM;
import com.hhstudygroup.npustudy.viewmodel.student.exam.ExamPaperSubmitItemVM;
import com.hhstudygroup.npustudy.viewmodel.student.question.answer.QuestionAnswerVM;
import com.hhstudygroup.npustudy.viewmodel.student.question.answer.QuestionPageStudentRequestVM;
import com.hhstudygroup.npustudy.viewmodel.student.question.answer.QuestionPageStudentResponseVM;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("StudentQuestionAnswerController")
@RequestMapping(value = "/api/student/question/answer")
public class QuestionAnswerController extends BaseApiController {

    private final ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService;
    private final QuestionService questionService;
    private final TextContentService textContentService;
    private final SubjectService subjectService;

    @Autowired
    public QuestionAnswerController(ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService, QuestionService questionService, TextContentService textContentService, SubjectService subjectService) {
        this.examPaperQuestionCustomerAnswerService = examPaperQuestionCustomerAnswerService;
        this.questionService = questionService;
        this.textContentService = textContentService;
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public RestResponse<PageInfo<QuestionPageStudentResponseVM>> pageList(@RequestBody QuestionPageStudentRequestVM model) {
        model.setCreateUser(getCurrentUser().getId());
        PageInfo<ExamPaperQuestionCustomerAnswer> pageInfo = examPaperQuestionCustomerAnswerService.studentPage(model);
        PageInfo<QuestionPageStudentResponseVM> page = PageInfoHelper.copyMap(pageInfo, q -> {
            Subject subject = subjectService.selectById(q.getSubjectId());
            QuestionPageStudentResponseVM vm = modelMapper.map(q, QuestionPageStudentResponseVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(q.getCreateTime()));
            TextContent textContent = textContentService.selectById(q.getQuestionTextContentId());
            QuestionObject questionObject = JsonUtil.toJsonObject(textContent.getContent(), QuestionObject.class);
            String clearHtml = HtmlUtil.clear(questionObject.getTitleContent());
            vm.setShortTitle(clearHtml);
            vm.setSubjectName(subject.getName());
            return vm;
        });
        return RestResponse.ok(page);
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<QuestionAnswerVM> select(@PathVariable Integer id) {
        QuestionAnswerVM vm = new QuestionAnswerVM();
        ExamPaperQuestionCustomerAnswer examPaperQuestionCustomerAnswer = examPaperQuestionCustomerAnswerService.selectById(id);
        ExamPaperSubmitItemVM questionAnswerVM = examPaperQuestionCustomerAnswerService.examPaperQuestionCustomerAnswerToVM(examPaperQuestionCustomerAnswer);
        QuestionEditRequestVM questionVM = questionService.getQuestionEditRequestVM(examPaperQuestionCustomerAnswer.getQuestionId());
        vm.setQuestionVM(questionVM);
        vm.setQuestionAnswerVM(questionAnswerVM);
        return RestResponse.ok(vm);
    }

}
