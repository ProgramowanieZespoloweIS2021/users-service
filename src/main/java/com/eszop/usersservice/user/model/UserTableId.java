package com.eszop.usersservice.user.model;

import lombok.*;

import java.io.Serializable;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Getter
public class UserTableId implements Serializable {

    private final Long value;

    public static UserTableId of(Long value) {
        return new UserTableId(value);
    }

}
