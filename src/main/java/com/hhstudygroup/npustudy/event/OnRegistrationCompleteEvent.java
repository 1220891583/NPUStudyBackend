package com.hhstudygroup.npustudy.event;

import com.hhstudygroup.npustudy.domain.User;
import org.springframework.context.ApplicationEvent;

/**
 * @author HHStudyGroup
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {


    private final User user;


    public OnRegistrationCompleteEvent(final User user) {
        super(user);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
