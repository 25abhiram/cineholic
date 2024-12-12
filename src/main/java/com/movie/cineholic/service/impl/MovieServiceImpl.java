package com.movie.cineholic.service.impl;

import com.movie.cineholic.model.Movie;
import com.movie.cineholic.repository.MovieRepository;
import com.movie.cineholic.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(String id,Movie movie) {
        if(movieRepository.existsById(id)) {
            movie.setId(id);
        }
        return movieRepository.save(movie);
    }


    @Override
    public void deleteMovie(String id) {
        movieRepository.deleteById(id);

    }

    @Override
    public Movie getMovieById(String id) {
        Optional<Movie> movie=movieRepository.findById(id);
        return movie.orElse(null) ;
    }
}
