package com.epam.airline.interceptor;

import com.epam.airline.dto.User;
import com.epam.airline.enums.Role;
import com.epam.airline.service.SessionUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {
    @Autowired
    private SessionUserManager sessionUserManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = sessionUserManager.getCurrentSessionUser();

        if (user == null || !user.getRole().equals(Role.ADMIN)) {
            response.sendRedirect("/index");
            return false;
        }
        return true;
    }
}
