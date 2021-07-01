package com.hhstudygroup.npustudy.viewmodel.admin.message;

import com.hhstudygroup.npustudy.base.BasePage;


public class MessagePageRequestVM extends BasePage {
    private String sendUserName;

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }
}
