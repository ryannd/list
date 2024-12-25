package com.ryannd.list_api.controller;

import com.ryannd.list_api.domain.UserList;
import com.ryannd.list_api.entity.User;
import com.ryannd.list_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired private UserService userService;

    @GetMapping()
    public Iterable<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/list")
    public UserList getList() {
        return userService.getList();
    }
}
