package com.epam.airline.interceptor;

import com.epam.airline.dto.User;
import com.epam.airline.service.SessionUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private SessionUserManager sessionUserManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = sessionUserManager.getCurrentSessionUser();

        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}