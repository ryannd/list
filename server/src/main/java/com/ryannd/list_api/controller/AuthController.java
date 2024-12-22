package com.ryannd.list_api.controller;

import com.ryannd.list_api.entity.User;
import com.ryannd.list_api.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
    @Autowired private AuthService authService;

    @PostMapping("/login")
    public User login(HttpServletRequest request) {
        return authService.login(request);
    }
}
