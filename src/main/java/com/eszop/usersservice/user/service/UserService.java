package com.eszop.usersservice.user.service;

import com.eszop.usersservice.user.model.User;
import com.eszop.usersservice.user.model.UserId;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByEmail(String username);
    
    User findById(Long id);

    List<User> findAll();

    void deleteUserById(UserId id);
}
