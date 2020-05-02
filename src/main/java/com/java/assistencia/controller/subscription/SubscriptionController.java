package com.java.assistencia.controller.subscription;

import com.java.assistencia.controller.command.subscription.SubscriptionCommand;
import com.java.assistencia.controller.command.subscription.SubscriptionSaveCommand;
import com.java.assistencia.controller.command.subscription.SubscriptionUpdateCommand;
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
    public ResponseEntity<Subscription> save(@Valid @RequestBody SubscriptionCommand subscriptionCommand) {
        Subscription subscription = service.save(subscriptionCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscription);
    }

    @GetMapping("/subscription/{id}")
    public ResponseEntity<Subscription> findById(@PathVariable("id") Long id) {
        Subscription subscription = service.findById(id);
        return ResponseEntity.ok(subscription);
    }

    @PutMapping("/subscription/{id}")
    public ResponseEntity<Subscription> update(@PathVariable("id") Long id, @RequestBody @Valid SubscriptionUpdateCommand subscriptionUpdateCommand) {
        Subscription subscription = subscriptionUpdateCommand.transformToSubscription();
        subscription.setId(id);
        Subscription result = service.update(subscription);
        return ResponseEntity.ok(result);
    }
}
