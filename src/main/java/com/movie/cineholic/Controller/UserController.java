package com.movie.cineholic.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
// @GetMapping
// public String allMovies(){
//     return "hello bro";
// }
@GetMapping
public ResponseEntity<String> allUsers(){
    return new ResponseEntity<String>("All Users",HttpStatus.OK);
}
}
