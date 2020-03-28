package com.java.assistencia.repository.user;

import com.java.assistencia.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE username = ?1 AND password = ?2")
    Optional<User> login(String username, String password);
}