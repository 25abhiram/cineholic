package com.movie.cineholic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.cineholic.Model.User;
import com.movie.cineholic.Repository.UserRepository;
import com.movie.cineholic.Service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) {
        try {
            if (userRepository.findByUsername(user.getUsername()).isPresent())
                return ResponseEntity.status(HttpStatus.CONFLICT).body("username already taken. Please try again");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User save = userRepository.save(user);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    // @PostMapping
    // public ResponseEntity<User> createUser(@RequestBody User user) {
    // User createdUser = this.userService.createUser(user);
    // return ResponseEntity.ok(createdUser);
    // }

    // @GetMapping("/{userId}")
    // public ResponseEntity<User> getUserById(@PathVariable String userId) {
    // User user = this.userService.getUserById(userId);
    // return user != null ? ResponseEntity.ok(user) :
    // ResponseEntity.notFound().build();
    // }

    // @GetMapping
    // public ResponseEntity<List<User>> getAllUsers() {
    // List<User> users = this.userService.getAllUsers();
    // return ResponseEntity.ok(users);
    // }

    // @PutMapping("/{userId}")
    // public ResponseEntity<User> updateUser(@PathVariable String userId,
    // @RequestBody User user) {
    // User updatedUser = this.userService.updateUser(userId, user);
    // return updatedUser != null ? ResponseEntity.ok(updatedUser) :
    // ResponseEntity.notFound().build();
    // }

    // @DeleteMapping("/{userId}")
    // public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
    // this.userService.deleteUser(userId);
    // return ResponseEntity.noContent().build();
    // }
}
