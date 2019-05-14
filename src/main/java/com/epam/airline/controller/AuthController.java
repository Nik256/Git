package com.epam.airline.controller;

import com.epam.airline.dto.User;
import com.epam.airline.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private SessionUserManager sessionUserManager;

    @GetMapping("/login")
    private ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login-registration/login");
        return modelAndView;
    }

    @PostMapping("/login")
    private ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (!userService.isLoginExist(user.getLogin())) {
            modelAndView.addObject("msg", "Неправильный логин");
            modelAndView.setViewName("/login-registration/login");
            return modelAndView;
        }
        else if(!userService.isPasswordCorrect(user)) {
            modelAndView.addObject("msg", "Неправильный пароль");
            modelAndView.setViewName("/login-registration/login");
            return modelAndView;
        }
        User foundUser = userService.authenticateUser(user);
        sessionUserManager.setCurrentSessionUser(foundUser);
        modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }

    @GetMapping("/registration")
    private ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login-registration/registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    private ModelAndView registration(User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.isLoginExist(user.getLogin())) {
            modelAndView.addObject("msg", "Такой логин уже существует");
            modelAndView.setViewName("/login-registration/registration");
            return modelAndView;
        }
        userService.registerUser(user);
        User foundUser = userService.authenticateUser(user);
        sessionUserManager.setCurrentSessionUser(foundUser);
        modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login-registration/login");
        request.getSession().invalidate();
        return modelAndView;
    }

    @GetMapping("/index")
    private ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        modelAndView.addObject("flights", flightService.findAll());
        modelAndView.addObject("aircrafts", aircraftService.findAll());
        modelAndView.addObject("airports", airportService.findAll());
        return modelAndView;
    }
}
