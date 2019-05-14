package com.epam.airline.repository;

import com.epam.airline.dto.User;
import com.epam.airline.enums.Role;

import java.util.List;

public interface UserRepository {

    void save(User user);

    void update(User user);

    void deleteById(long id);

    User findById(long id);

    User findByLogin(String login);

    List<User> findAll();

    List<User> findByRole(Role role);
}
