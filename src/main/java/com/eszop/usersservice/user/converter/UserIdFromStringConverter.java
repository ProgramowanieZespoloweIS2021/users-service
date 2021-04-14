package com.eszop.usersservice.user.converter;
import org.springframework.core.convert.converter.Converter;

import com.eszop.usersservice.user.model.UserId;

public class UserIdFromStringConverter implements Converter<Long, UserId>{
    @Override
    public UserId convert(Long value) {
        return UserId.of(value);
    }
}

