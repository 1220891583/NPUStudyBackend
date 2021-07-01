package com.hhstudygroup.npustudy.controller.wx;

import com.hhstudygroup.npustudy.context.WxContext;
import com.hhstudygroup.npustudy.domain.User;
import com.hhstudygroup.npustudy.domain.UserToken;
import com.hhstudygroup.npustudy.utility.ModelMapperSingle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseWXApiController {
    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();
    @Autowired
    private WxContext wxContext;

    protected User getCurrentUser() {
        return wxContext.getCurrentUser();
    }

    protected UserToken getUserToken() {
        return wxContext.getCurrentUserToken();
    }
}
