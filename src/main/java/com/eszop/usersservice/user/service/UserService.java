package com.eszop.usersservice.user.service;

import com.eszop.usersservice.user.model.User;
import com.eszop.usersservice.user.model.UserId;
import com.eszop.usersservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void save(User user) {
        userRepository.save(user);
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public User findById(Long id) {
        return userRepository.findById(id);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }


    public void deleteUserById(UserId id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
    }
}
