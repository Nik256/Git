package com.epam.airline.config;

import com.epam.airline.interceptor.AdminInterceptor;
import com.epam.airline.interceptor.AuthInterceptor;
import com.epam.airline.interceptor.UserAwareInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public AdminInterceptor adminInterceptor() {
        return new AdminInterceptor();
    }

    @Bean
    public UserAwareInterceptor userAwareInterceptor() {
        return new UserAwareInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/registration",
                        "/logout", "/css/**", "/js/**", "/img/**", "/error");

        registry.addInterceptor(userAwareInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/registration",
                        "/logout", "/css/**", "/js/**", "/img/**", "/error");

        registry.addInterceptor(adminInterceptor())
                .addPathPatterns("/users", "/user/**", "/edit-user/", "/create-user/", "/delete-user/",
                        "/delete-flight/");
    }
}
