package com.eszop.usersservice.user.dto;

import com.eszop.usersservice.user.model.User;
import com.eszop.usersservice.user.model.UserId;

public class UserDTOMapper {

    public static UserDTO map(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .build();
    }

    public static User map(UserDTO userDTO) {
        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
