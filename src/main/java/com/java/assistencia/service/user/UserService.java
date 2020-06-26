package com.java.assistencia.service.user;

import com.java.assistencia.controller.command.user.UserCommand;
import com.java.assistencia.controller.command.user.UserPasswordCommand;
import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.domain.user.User;
import com.java.assistencia.exception.NotFoundException;
import com.java.assistencia.repository.subscription.SubscriptionRepository;
import com.java.assistencia.repository.user.UserRepository;
import com.java.assistencia.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public User save(UserCommand userCommand) {
        User user = new User();
        user = userCommand.bindData(user);

//        if (isNull(userCommand.getSubscription().getId())) {
//            throw new NotFoundException("Empresa não existe com o id: " + userCommand.getSubscription().getId());
//        }
//        Optional<Subscription> subscription = subscriptionRepository.findById(userCommand.getSubscription().getId());
//        if (!subscription.isPresent()) {
//            throw new NotFoundException("Empresa não existe com o id: " + userCommand.getSubscription().getId());
//        }
//        user.setSubscription(subscription.get());
//        if (!user.getSubscription().getId().equals(subscription.get().getId())) {
//            throw new NotFoundException("Empresa não encontrada com o id: " + subscription.get().getId() + " para este usuário.");
//        }

        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public User login(String username, String password) {
        return userRepository.login(username, password);
    }

    public User update(Long id, UserCommand userCommand) {
//        Optional<User> result = userRepository.findById(id);
//        result.orElseThrow(()-> new NotFoundException("Usuário não encontrado com o id: " + id));
//
//        User user = userCommand.bindData(result.get());
        return null;
    }

    public int updatePassword(Long id, UserPasswordCommand userPasswordCommand) {
        String password = HashUtil.getSecureHash(userPasswordCommand.getPassword());
        return userRepository.updatePassword(id, password);
    }
}