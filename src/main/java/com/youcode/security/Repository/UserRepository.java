package com.youcode.security.Repository;

import com.youcode.security.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


//    Boolean existsByUsername(String username);
    Boolean existsUserByUsername(String username);


//    User findByUsername(String username);
    Optional<User> findUserByUsername(String username);
}
