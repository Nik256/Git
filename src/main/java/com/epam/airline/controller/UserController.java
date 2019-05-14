package com.epam.airline.controller;

import com.epam.airline.dto.User;
import com.epam.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    private ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/users");
        modelAndView.addObject("users", userService.getDispatchers());
        //supercomment
        return modelAndView;
    }

    @GetMapping("/user/{id}")
    private ModelAndView editUser(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/user");
        modelAndView.addObject("user", userService.getUserById(id));
        return modelAndView;
    }

    @PostMapping("/create-user")
    private ModelAndView createUser(User user) {
        userService.registerUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }

    @PostMapping("/edit-user")
    private ModelAndView editUser(User user) {
        userService.editUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }

    @GetMapping("/user")
    private ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/user");
        return modelAndView;
    }

    @GetMapping("/delete-user/{id}")
    private ModelAndView deleteFlight(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        User userToDelete = userService.getUserById(id);
        userService.deleteUser(userToDelete);
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }
}
