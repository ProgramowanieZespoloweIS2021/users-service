package com.eszop.usersservice.user.controller;

import com.eszop.usersservice.user.dto.UserDTO;
import com.eszop.usersservice.user.dto.UserDTOMapper;
import com.eszop.usersservice.user.model.User;
import com.eszop.usersservice.user.model.UserId;
import com.eszop.usersservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
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
    public void addUser(@RequestBody UserDTO user){
        userService.save(UserDTOMapper.map(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UserId id) {
        userService.deleteUserById(id);
    }

    @GetMapping
    @ResponseBody
    public List<UserDTO> getUsers(@RequestParam(required = false) String username){
        if (username != null && !username.isEmpty()) {
            return Collections.singletonList(UserDTOMapper.map(userService.findByUsername(username)));
        }
        return userService.findAll().stream().map(UserDTOMapper::map).collect(Collectors.toList());
    }

}
