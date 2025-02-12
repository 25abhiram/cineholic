package com.movie.cineholic.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.cineholic.Model.Movie;
import com.movie.cineholic.Model.User;
import com.movie.cineholic.Repository.MovieRepository;
import com.movie.cineholic.Repository.UserRepository;
import com.movie.cineholic.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

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
    public User addMovieToWatchlist(String userId, String movieId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);

        if (optionalUser.isPresent() && optionalMovie.isPresent()) {
            User user = optionalUser.get();
            Movie movie = optionalMovie.get();

            if (user.getWatchlist() == null) {
                user.setWatchlist(new ArrayList<>()); // Initialize list if null
            }

            // Ensure unique movies in watchlist
            if (!user.getWatchlist().contains(movie)) {
                user.getWatchlist().add(movie);
                return userRepository.save(user);
            }
        }
        return null;
    }

    @Override
    public List<Movie> getWatchlist(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(User::getWatchlist).orElse(new ArrayList<>());
    }

    @Override
    public User removeMovieFromWatchlist(String userId, String movieId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);

        if (optionalUser.isPresent() && optionalMovie.isPresent()) {
            User user = optionalUser.get();
            Movie movie = optionalMovie.get();

            if (user.getWatchlist() != null && user.getWatchlist().contains(movie)) {
                user.getWatchlist().remove(movie);
                return userRepository.save(user);
            }
        }
        return null;
    }
}
