package com.java.assistencia.controller.user;

import com.java.assistencia.controller.command.user.UserLoginCommand;
import com.java.assistencia.controller.command.user.UserSaveCommand;
import com.java.assistencia.controller.command.user.UserUpdateCommand;
import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.domain.user.User;
import com.java.assistencia.service.subscription.SubscriptionService;
import com.java.assistencia.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody @Valid UserSaveCommand userSaveCommand) {
        User user = userSaveCommand.transformToUser();
        User result = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        User result = userService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/user/login")
    public ResponseEntity<User> login(@RequestBody @Valid UserLoginCommand userLoginCommand) {
        User result = userService.login(userLoginCommand.getUsername(), userLoginCommand.getPassword());
        return ResponseEntity.ok(result);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody @Valid UserUpdateCommand userUpdateCommand) {
        User user = userUpdateCommand.transformToUser();
        user.setId(id);
        User result = userService.update(user);
        return ResponseEntity.ok(result);
    }
}
