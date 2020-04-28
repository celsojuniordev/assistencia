package com.java.assistencia.service.user;

import com.java.assistencia.domain.user.User;
import com.java.assistencia.exception.NotFoundException;
import com.java.assistencia.repository.user.UserRepository;
import com.java.assistencia.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        String hash = HashUtil.getSecureHash(user.getPassword());
        user.setPassword(hash);
        return userRepository.save(user);
    }

    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        return result.orElseThrow(()-> new NotFoundException("Usuário não encontrado com o id: " + id));
    }

    public User login(String username, String password) {
        password = HashUtil.getSecureHash(password);
        Optional<User> result = userRepository.login(username, password);
        return result.get();
    }

    public User update(User user) {
        String password = HashUtil.getSecureHash(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }
}