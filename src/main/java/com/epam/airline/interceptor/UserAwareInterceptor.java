package com.epam.airline.interceptor;

import com.epam.airline.dto.User;
import com.epam.airline.service.SessionUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAwareInterceptor implements HandlerInterceptor {
    @Autowired
    private SessionUserManager sessionUserManager;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        User currentSessionUser = sessionUserManager.getCurrentSessionUser();

        if (currentSessionUser != null && modelAndView != null) {
            modelAndView.addObject("role", currentSessionUser.getRole());
        }
    }
}
