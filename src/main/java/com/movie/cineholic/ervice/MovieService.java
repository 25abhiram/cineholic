package com.movie.cineholic.ervice;

import java.util.List;

import com.movie.cineholic.odel.Movie;

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
