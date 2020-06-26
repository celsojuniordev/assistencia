package com.java.assistencia.repository.user.impl;

import com.java.assistencia.domain.user.User;
import com.java.assistencia.exception.NotFoundException;
import com.java.assistencia.repository.user.UserRepository;
import com.java.assistencia.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserRepositoryJpa jpa;

    @Override
    public User login(String username, String password) {
        password = HashUtil.getSecureHash(password);
        Optional<User> result = jpa.login(username, password);
        return result.orElseThrow(()-> new NotFoundException("Usuário ou senha inválidos"));
    }

    @Override
    public int updatePassword(Long id, String password) {
        return 0;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        Optional<User> result = jpa.findById(id);
        return result.orElseThrow(()-> new NotFoundException("Usuário não encontrado com o id: " + id));
    }

    @Override
    public void update(Long id, User user) {

    }
}
