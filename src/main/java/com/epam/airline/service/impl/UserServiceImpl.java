package com.epam.airline.service.impl;

import com.epam.airline.dto.User;
import com.epam.airline.enums.Role;
import com.epam.airline.repository.UserRepository;
import com.epam.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User authenticateUser(User user) {
        User foundUser = userRepository.findByLogin(user.getLogin());
        return foundUser;
    }

    @Override
    public Boolean isLoginExist(String login) {
        return userRepository.findByLogin(login) != null;
    }

    @Override
    public void editUser(User user) {
        userRepository.update(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Boolean isPasswordCorrect(User user) {
        return userRepository.findByLogin(user.getLogin())
                .getPassword()
                .equals(user.getPassword());
    }

    @Override
    public List<User> getDispatchers() {
        return userRepository.findByRole(Role.DISPATCHER);
    }
}
