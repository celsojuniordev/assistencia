package com.java.assistencia.repository.user.impl;

import com.java.assistencia.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepositoryJpa extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE username = ?1 AND password = ?2")
    Optional<User> login(String username, String password);

    @Modifying
    @Transactional(readOnly = false)
    @Query("UPDATE User SET password = ?2 WHERE id = ?1")
    int updatePassword(Long id, String password);
}
