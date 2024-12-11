package com.movie.cineholic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.cineholic.Model.User;
import com.movie.cineholic.Service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

@Autowired
private UserService userService;

@PostMapping
public ResponseEntity<User> createUser(@RequestBody User user){
    User createdUser=this.userService.createUser(user);
    return ResponseEntity.ok(createdUser);
}

@GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable long id){
    User user=this.userService.getUserById(id);
    return user!=null?ResponseEntity.ok(user):ResponseEntity.notFound().build();
}

@GetMapping
public ResponseEntity<List<User>> getAllUsers(){
    List<User> users=this.userService.getAllUsers();
    return ResponseEntity.ok(users);
}

@PutMapping
public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User user){
    User updatedUser=this.userService.updateUser(id, user);
    return updatedUser!=null?ResponseEntity.ok(updatedUser):ResponseEntity.notFound().build();
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable long id){
    this.userService.deleteUser(id);
    return ResponseEntity.noContent().build();
}
}
