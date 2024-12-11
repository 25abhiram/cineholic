package com.movie.cineholic.Service;

import java.util.List;

import com.movie.cineholic.Model.User;

public interface UserService {
User createUser(User user);
User getUserById(long id);
List<User> getAllUsers();
User updateUser(long id,User user);
void deleteUser(long id);
}
