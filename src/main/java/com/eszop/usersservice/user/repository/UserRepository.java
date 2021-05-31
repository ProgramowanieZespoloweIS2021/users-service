package com.eszop.usersservice.user.repository;

import com.eszop.usersservice.user.model.UserTable;
import com.eszop.usersservice.user.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTable, UserId> {
    UserTable findByEmail(String email);

    UserTable findById(Long id);
}
