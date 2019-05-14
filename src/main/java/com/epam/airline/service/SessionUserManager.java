package com.epam.airline.service;

import com.epam.airline.dto.User;

public interface SessionUserManager {

    User setCurrentSessionUser(User user);

    User getCurrentSessionUser();
}
