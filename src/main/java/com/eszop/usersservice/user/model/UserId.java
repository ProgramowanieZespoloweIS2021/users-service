package com.eszop.usersservice.user.model;

import lombok.*;

import java.io.Serializable;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Getter
public class UserId implements Serializable {

    private final Long value;

    public static UserId of(Long value) {
        return new UserId(value);
    }

}
