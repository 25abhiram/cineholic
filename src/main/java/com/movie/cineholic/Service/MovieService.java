package com.movie.cineholic.Service;

import java.util.List;
import java.util.Optional;

import com.movie.cineholic.Model.Movie;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie addMovie(Movie movie);
    Movie updateMovie(String movieId,Movie movie);
    void deleteMovie(String movieId);
    Optional<Movie> getMovieById(String movieId);
    List<Movie> getMoviesByGenres(String genres);
    List<Movie> getMoviesByTitle(String title);
    List<Movie> getMoviesWithRatingAbove(double averageRating);
    List<Movie> getTop10Movies();
    List<Movie> getRecentlyReleasedMovie();  
}
