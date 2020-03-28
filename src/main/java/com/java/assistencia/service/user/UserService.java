package com.java.assistencia.service.user;

import com.java.assistencia.domain.user.User;
import com.java.assistencia.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        return result.orElseThrow(()-> new RuntimeException("Usuário não encontrado com o id: " + id));
    }

    public User login(String username, String password) {
        Optional<User> result = userRepository.login(username, password);
        return result.get();
    }
}