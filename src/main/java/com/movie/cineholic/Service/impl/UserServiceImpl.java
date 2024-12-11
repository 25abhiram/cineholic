package com.movie.cineholic.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.cineholic.Model.User;
import com.movie.cineholic.Repository.UserRepository;
import com.movie.cineholic.Service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    // public List<User> allUsers() {
    //     return userRepository.findAll();
    // }

    // public Optional<User> singlUser(Long id){
    //     return userRepository.findById(id);
    // }

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getUserById(long id){
        Optional<User> user=userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User updateUser(long id,User user){
        if(userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }
    
    @Override
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
