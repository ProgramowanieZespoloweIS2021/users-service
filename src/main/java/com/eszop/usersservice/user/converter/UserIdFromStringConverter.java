package com.eszop.usersservice.user.converter;
import org.springframework.core.convert.converter.Converter;

import com.eszop.usersservice.user.model.UserTableId;

public class UserIdFromStringConverter implements Converter<Long, UserTableId>{
    @Override
    public UserTableId convert(Long value) {
        return UserTableId.of(value);
    }
}

