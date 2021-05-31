package com.eszop.usersservice.user.dto;

import com.eszop.usersservice.user.model.UserTable;

public class UserDTOMapper {

    public static UserDTO map(UserTable user) {
        return UserDTO.builder()
                .id(user.getId())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .build();
    }

    public static UserTable map(UserDTO userDTO) {
        UserTable user = new UserTable();
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
