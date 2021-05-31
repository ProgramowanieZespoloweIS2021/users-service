package com.eszop.usersservice.user.controller;

import com.eszop.usersservice.user.dto.UserDTO;
import com.eszop.usersservice.user.dto.UserDTOMapper;
import com.eszop.usersservice.user.model.User;
import com.eszop.usersservice.user.model.UserId;
import com.eszop.usersservice.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody UserDTO user){
        if (userService.findByEmail(user.getEmail()) == null) {
            userService.save(UserDTOMapper.map(user));
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UserId id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getUsers(@RequestParam(required = false) String email){
        //TODO enable calls only by auth service
        if (email != null && !email.isEmpty()) {
            return Optional.ofNullable(userService.findByEmail(email))
                    .map(user -> Collections.singletonList(UserDTOMapper.map(user)))
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        }
        return Optional.ofNullable(userService.findAll())
                .map(users -> users.stream().map(user -> UserDTOMapper.map(user)).collect(Collectors.toList()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
