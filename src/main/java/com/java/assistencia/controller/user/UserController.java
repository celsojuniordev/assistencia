package com.java.assistencia.controller.user;

import com.java.assistencia.controller.command.user.UserCommand;
import com.java.assistencia.controller.command.user.UserLoginCommand;
import com.java.assistencia.controller.command.user.UserPasswordCommand;
import com.java.assistencia.domain.user.User;
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
    public ResponseEntity<User> save(@Valid @RequestBody UserCommand userCommand) {
        User user = userService.save(userCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
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
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody @Valid UserCommand userCommand) {
        User result = userService.update(id, userCommand);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<?> updatePassword(@PathVariable("id") Long id, @RequestBody @Valid UserPasswordCommand userPasswordCommand) {
        userService.updatePassword(id, userPasswordCommand);
        return ResponseEntity.ok().build();
    }
}
