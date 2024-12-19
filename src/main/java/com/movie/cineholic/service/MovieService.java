package com.movie.cineholic.service;

import com.movie.cineholic.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie addMovie(Movie movie);
    Movie updateMovie(String movieId,Movie movie);
    void deleteMovie(String movieId);
    Movie getMovieById(String movieId);
    List<Movie> getMoviesByGenre(String genre);
    List<Movie> getMoviesByTitle(String title);
    List<Movie> getMoviesWithRatingAbove(double rating);

}
