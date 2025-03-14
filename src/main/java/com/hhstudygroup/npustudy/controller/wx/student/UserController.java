package com.hhstudygroup.npustudy.controller.wx.student;

import com.hhstudygroup.npustudy.base.RestResponse;
import com.hhstudygroup.npustudy.controller.wx.BaseWXApiController;
import com.hhstudygroup.npustudy.domain.Message;
import com.hhstudygroup.npustudy.domain.MessageUser;
import com.hhstudygroup.npustudy.domain.User;
import com.hhstudygroup.npustudy.domain.UserEventLog;
import com.hhstudygroup.npustudy.domain.enums.RoleEnum;
import com.hhstudygroup.npustudy.domain.enums.UserStatusEnum;
import com.hhstudygroup.npustudy.event.UserEvent;
import com.hhstudygroup.npustudy.service.*;
import com.hhstudygroup.npustudy.utility.DateTimeUtil;
import com.hhstudygroup.npustudy.utility.PageInfoHelper;
import com.hhstudygroup.npustudy.viewmodel.student.user.*;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * @author HHStudyGroup
 */
@Controller("WXStudentUserController")
@RequestMapping(value = "/api/wx/student/user")
@ResponseBody
public class UserController extends BaseWXApiController {

    private final UserService userService;
    private final UserEventLogService userEventLogService;
    private final MessageService messageService;
    private final AuthenticationService authenticationService;
    private final ApplicationEventPublisher eventPublisher;
    private final FileUpload fileUpload;

    @Autowired
    public UserController(UserService userService, UserEventLogService userEventLogService, MessageService messageService, AuthenticationService authenticationService, ApplicationEventPublisher eventPublisher, FileUpload fileUpload) {
        this.userService = userService;
        this.userEventLogService = userEventLogService;
        this.messageService = messageService;
        this.authenticationService = authenticationService;
        this.eventPublisher = eventPublisher;
        this.fileUpload = fileUpload;
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse questionUploadAndReadExcel(@RequestParam("file") MultipartFile multipartFile) {
        System.out.println(1111);
        long attachSize = multipartFile.getSize();
        String imgName = multipartFile.getOriginalFilename();
        try (InputStream inputStream = multipartFile.getInputStream()) {
            String filePath = fileUpload.uploadFile(inputStream, attachSize, imgName);
            userService.changePicture(getCurrentUser(), filePath);
            return RestResponse.ok(filePath);
        } catch (IOException e) {
            return RestResponse.fail(2, e.getMessage());
        }
    }

    @RequestMapping(value = "/current", method = RequestMethod.POST)
    public RestResponse<UserResponseVM> current() {
        User user = getCurrentUser();
        UserResponseVM userVm = UserResponseVM.from(user);
        userVm.setBirthDay(DateTimeUtil.dateShortFormat(user.getBirthDay()));
        return RestResponse.ok(userVm);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RestResponse register(@Valid UserRegisterVM model) {
        User existUser = userService.getUserByUserName(model.getUserName());
        if (null != existUser) {
            return new RestResponse<>(2, "用户已存在");
        }
        User user = modelMapper.map(model, User.class);
        String encodePwd = authenticationService.pwdEncode(model.getPassword());
        user.setUserUuid(UUID.randomUUID().toString());
        user.setPassword(encodePwd);
        user.setRole(RoleEnum.STUDENT.getCode());
        user.setStatus(UserStatusEnum.Enable.getCode());
        user.setLastActiveTime(new Date());
        user.setCreateTime(new Date());
        user.setDeleted(false);
        userService.insertByFilter(user);
        UserEventLog userEventLog = new UserEventLog(user.getId(), user.getUserName(), user.getRealName(), new Date());
        userEventLog.setContent("欢迎 " + user.getUserName() + " 注册来到小瓜答题宝");
        eventPublisher.publishEvent(new UserEvent(userEventLog));
        return RestResponse.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RestResponse<UserResponseVM> update(@Valid UserUpdateVM model) {
        if (StringUtils.isBlank(model.getBirthDay())) {
            model.setBirthDay(null);
        }
        User user = userService.selectById(getCurrentUser().getId());
        modelMapper.map(model, user);
        user.setModifyTime(new Date());
        userService.updateByIdFilter(user);
        UserEventLog userEventLog = new UserEventLog(user.getId(), user.getUserName(), user.getRealName(), new Date());
        userEventLog.setContent(user.getUserName() + " 更新了个人资料");
        eventPublisher.publishEvent(new UserEvent(userEventLog));
        UserResponseVM userVm = UserResponseVM.from(user);
        return RestResponse.ok(userVm);
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public RestResponse<List<UserEventLogVM>> log() {
        User user = getCurrentUser();
        List<UserEventLog> userEventLogs = userEventLogService.getUserEventLogByUserId(user.getId());
        List<UserEventLogVM> userEventLogVMS = userEventLogs.stream().map(d -> {
            UserEventLogVM vm = modelMapper.map(d, UserEventLogVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(d.getCreateTime()));
            return vm;
        }).collect(Collectors.toList());
        return RestResponse.ok(userEventLogVMS);
    }

    @RequestMapping(value = "/message/page", method = RequestMethod.POST)
    public RestResponse<PageInfo<MessageResponseVM>> messagePageList(MessageRequestVM messageRequestVM) {
        messageRequestVM.setReceiveUserId(getCurrentUser().getId());
        PageInfo<MessageUser> messageUserPageInfo = messageService.studentPage(messageRequestVM);
        List<Integer> ids = messageUserPageInfo.getList().stream().map(d -> d.getMessageId()).collect(Collectors.toList());
        List<Message> messages = ids.size() != 0 ? messageService.selectMessageByIds(ids) : null;
        PageInfo<MessageResponseVM> page = PageInfoHelper.copyMap(messageUserPageInfo, e -> {
            MessageResponseVM vm = modelMapper.map(e, MessageResponseVM.class);
            messages.stream().filter(d -> e.getMessageId().equals(d.getId())).findFirst().ifPresent(message -> {
                vm.setTitle(message.getTitle());
                vm.setContent(message.getContent());
                vm.setSendUserName(message.getSendUserName());
            });
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));
            return vm;
        });
        return RestResponse.ok(page);
    }

    @RequestMapping(value = "/message/detail/{id}", method = RequestMethod.POST)
    public RestResponse messageDetail(@PathVariable Integer id) {
        Message message = messageService.messageDetail(id);
        return RestResponse.ok(message);
    }


    @RequestMapping(value = "/message/unreadCount", method = RequestMethod.POST)
    public RestResponse unReadCount() {
        Integer count = messageService.unReadCount(getCurrentUser().getId());
        return RestResponse.ok(count);
    }

    @RequestMapping(value = "/message/read/{id}", method = RequestMethod.POST)
    public RestResponse read(@PathVariable Integer id) {
        messageService.read(id);
        return RestResponse.ok();
    }

}
