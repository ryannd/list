package com.ryannd.list_api.repository;

import com.ryannd.list_api.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {}
