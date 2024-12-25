package com.ryannd.list_api.service;

import com.ryannd.list_api.domain.UserList;
import com.ryannd.list_api.entity.Entry;
import com.ryannd.list_api.entity.User;
import com.ryannd.list_api.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public void updateUser(User user) {
        this.userRepository.save(user);
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String uid = authentication.getName();
        Optional<User> user = userRepository.findById(uid);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("USER NOT FOUND");
        }
    }

    public UserList getList() {
        try {
            User user = getCurrentUser();
            UserList list = new UserList();
            List<Entry> entries = user.getEntries();

            entries.forEach(
                    entry -> {
                        switch (entry.getStatus()) {
                            case Entry.Status.PLANNING:
                                list.planning.add(entry);
                                break;
                            case Entry.Status.WATCHING:
                                list.watching.add(entry);
                                break;
                            case Entry.Status.COMPLETED:
                                list.completed.add(entry);
                                break;
                            default:
                                break;
                        }
                    });

            return list;
        } catch (Exception e) {
            throw e;
        }
    }
}
