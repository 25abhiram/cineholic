package com.movie.cineholic.service;

import com.movie.cineholic.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie addMovie(Movie movie);
    Movie updateMovie(String id,Movie movie);
    void deleteMovie(String id);
    Movie getMovieById(String id);
}
