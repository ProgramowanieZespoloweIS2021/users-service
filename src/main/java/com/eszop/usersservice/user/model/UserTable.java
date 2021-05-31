package com.eszop.usersservice.user.model;

import com.eszop.usersservice.user.dto.UserDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user_table")
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String surname;

    // should be array of chars, bcs string stays in string pool and someone can easliy extract password from heap
    // just for student project purposes
    private String password;


    private String email;

}
