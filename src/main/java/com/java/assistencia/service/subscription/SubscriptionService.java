package com.java.assistencia.service.subscription;

import com.java.assistencia.controller.command.subscription.SubscriptionCommand;
import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.exception.NotFoundException;
import com.java.assistencia.repository.subscription.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription save(SubscriptionCommand subscriptionCommand) {
        Subscription subscription = subscriptionCommand.bindData(new Subscription());
        return subscriptionRepository.save(subscription);
    }

    public Subscription findById(Long id) {
        Optional<Subscription> result = subscriptionRepository.findById(id);
        return result.orElseThrow(()-> new NotFoundException("Empresa não encontrada com o id: " + id));
    }

    public Subscription update(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }
}
