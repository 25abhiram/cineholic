package com.movie.cineholic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.cineholic.Model.User;
import com.movie.cineholic.Service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
// @GetMapping
// public String allMovies(){
//     return "hello bro";
// }
@Autowired
private UserServiceImpl userServiceImpl;
@GetMapping
public ResponseEntity<List<User>> getAllUsers(){
    return new ResponseEntity<List<User>>(userServiceImpl.allUsers(), HttpStatus.OK);

}
}
