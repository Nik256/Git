package com.epam.airline.service.impl;

import com.epam.airline.dto.User;
import com.epam.airline.service.SessionUserManager;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class SessionUserManagerImpl implements SessionUserManager {

    private User currentSessionUser;

    @Override
    public User setCurrentSessionUser(User user) {
        this.currentSessionUser = user;
        return this.currentSessionUser;
    }

    @Override
    public User getCurrentSessionUser() {
        return this.currentSessionUser;
    }
}
