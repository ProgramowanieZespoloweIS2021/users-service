package com.eszop.usersservice.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder(builderClassName = "Builder", toBuilder = true)
@Getter
@EqualsAndHashCode
@ToString
@JsonDeserialize(builder = UserDTO.Builder.class)
public class UserDTO {

    private Long id;

    private String firstName;

    private String surname;

    // should be array of chars, bcs string stays in string pool and someone can easliy extract password from heap
    // just for student project purposes
    private String password;

    private String email;
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {

    }
}
