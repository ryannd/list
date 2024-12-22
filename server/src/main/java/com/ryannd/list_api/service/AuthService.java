package com.ryannd.list_api.service;

import com.ryannd.list_api.entity.User;
import com.ryannd.list_api.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired UserRepository userRepository;

    public AuthService() {}

    public User login(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String uid = authentication.getName();
        Optional<User> user = userRepository.findById(uid);

        if (user.isPresent()) {
            return user.get();
        } else {
            String email = (String) request.getAttribute("email");
            String name = (String) request.getAttribute("name");
            User newUser = new User(authentication.getName(), name, email);
            userRepository.save(newUser);
            return newUser;
        }
    }
}
