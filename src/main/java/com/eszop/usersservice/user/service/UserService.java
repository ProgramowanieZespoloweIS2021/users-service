package com.eszop.usersservice.user.service;

import com.eszop.usersservice.user.model.UserTable;
import com.eszop.usersservice.user.model.UserTableId;
import com.eszop.usersservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void save(UserTable userTable) {
        userRepository.save(userTable);
    }


    public UserTable findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public UserTable findById(Long id) {
        return userRepository.findById(id);
    }


    public List<UserTable> findAll() {
        return userRepository.findAll();
    }


    public void deleteUserById(UserTableId id) {
        UserTable user = userRepository.getOne(id);
        userRepository.delete(user);
    }
}
