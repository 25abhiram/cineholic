package com.movie.cineholic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.cineholic.Model.Movie;
import com.movie.cineholic.Model.User;
import com.movie.cineholic.Service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = this.userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user = this.userService.getUserById(userId);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId,
            @RequestBody User user) {
        User updatedUser = this.userService.updateUser(userId, user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        this.userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/watchlist/{movieId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<User> addMovieToWatchlist(@PathVariable String userId, @PathVariable String movieId) {
        User updatedUser = this.userService.addMovieToWatchlist(userId, movieId);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{userId}/watchlist")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Movie>> getUserWatchlist(@PathVariable String userId) {
        List<Movie> watchlist = userService.getWatchlist(userId);
        return ResponseEntity.ok(watchlist);
    }

    @DeleteMapping("/{userId}/watchlist/{movieId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<User> removeMovieFromWatchlist(@PathVariable String userId, @PathVariable String movieId) {
        User updatedUser = userService.removeMovieFromWatchlist(userId, movieId);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{userId}/preferences")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<User> updateUserPreferences(@PathVariable String userId,
            @RequestBody List<String> preferences) {
        User updatedUser = userService.updateUserPreferences(userId, preferences);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{userId}/preferences")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<String>> getUserPreferences(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return user != null ? ResponseEntity.ok(user.getPreferences()) : ResponseEntity.notFound().build();
    }

}
