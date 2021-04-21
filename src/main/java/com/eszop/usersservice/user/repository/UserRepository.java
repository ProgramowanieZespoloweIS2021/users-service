package com.eszop.usersservice.user.repository;

import com.eszop.usersservice.user.model.User;
import com.eszop.usersservice.user.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
    User findByEmail(String email);

    User findById(Long id);
}
