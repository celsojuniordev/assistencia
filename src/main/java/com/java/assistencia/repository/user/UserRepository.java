package com.java.assistencia.repository.user;

import com.java.assistencia.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository {

    User login(String username, String password);

    int updatePassword(Long id, String password);

    User save(User user);

    User findById(Long id);

    void update(Long id, User user);
}
