package com.movie.cineholic.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movie.cineholic.Model.User;
import com.movie.cineholic.Repository.UserRepository;
import com.movie.cineholic.Service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String userId, User user) {
        if (userRepository.existsById(userId)) {
            user.setUserId(userId);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username.toLowerCase());
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(username);
        } else {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.get().getUsername())
                    .password(user.get().getPassword())
                    .build();
        }
    }
}
// @Override
// public UserDetails loadUserByUsername(String username) throws
// UsernameNotFoundException {
// Optional<User> user = userRepository.findByUsername(username);
// if (user.isPresent()) {
// var userObj = user.get();
// return org.springframework.security.core.userdetails.User.builder()
// .username(userObj.getUsername())
// .password(userObj.getPassword())
// .build();

// } else {
// throw new UsernameNotFoundException(username);
// }
// }