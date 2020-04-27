package com.java.assistencia.controller.subscription;

import com.java.assistencia.controller.command.subscription.SubscriptionSaveCommand;
import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.service.subscription.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping("/subscription")
    public ResponseEntity<Subscription> save(@Valid @RequestBody SubscriptionSaveCommand subscriptionSaveCommand) {
        Subscription subscription = subscriptionSaveCommand.transformToSubscription();
        Subscription result = service.save(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/subscription/{id}")
    public ResponseEntity<Subscription> findById(@PathVariable("id") Long id) {
        Subscription subscription = service.findById(id);
        return ResponseEntity.ok(subscription);
    }
}
