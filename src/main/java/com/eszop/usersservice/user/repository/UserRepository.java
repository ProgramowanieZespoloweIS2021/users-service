package com.eszop.usersservice.user.repository;

import com.eszop.usersservice.user.model.UserTable;
import com.eszop.usersservice.user.model.UserTableId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTable, UserTableId> {
    UserTable findByEmail(String email);

    UserTable findById(Long id);
}
