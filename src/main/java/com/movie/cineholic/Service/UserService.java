package com.movie.cineholic.Service;

import java.util.List;

import com.movie.cineholic.Model.User;

public interface UserService {
User createUser(User user);
User getUserById(String id);
List<User> getAllUsers();
User updateUser(String id,User user);
void deleteUser(String id);
}
