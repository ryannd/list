package com.ryannd.list_api.service;

import com.ryannd.list_api.entity.User;
import com.ryannd.list_api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAllUsers() {
        return this.userRepository.findAll();
    }
}
