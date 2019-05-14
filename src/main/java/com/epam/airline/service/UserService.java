package com.epam.airline.service;

import com.epam.airline.dto.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    User authenticateUser(User user);

    Boolean isLoginExist(String login);

    void editUser(User user);

    void deleteUser(User user);

    User getUserById(long id);

    Boolean isPasswordCorrect(User user);

    List<User> getDispatchers();
}
