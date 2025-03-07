package com.movie.cineholic.Service.impl;

import com.movie.cineholic.Model.Movie;
import com.movie.cineholic.Repository.MovieRepository;
import com.movie.cineholic.Service.MovieService;

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
    public Movie updateMovie(String movieId, Movie movie) {
        if (movieRepository.existsById(movieId)) {
            movie.setMovieId(movieId);
        }
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);

    }

    @Override
    public Optional<Movie> getMovieById(String movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public List<Movie> getMoviesByGenres(String genres) {
    return movieRepository.findByGenresContainingIgnoreCase(genres);
}


    @Override
    public List<Movie> getMoviesByTitle(String title) {
    return movieRepository.findByTitleContainingIgnoreCase(title);
}

@Override
public List<Movie> getMoviesWithRatingAbove(double averageRating) {
    return movieRepository.findByAverageRatingGreaterThan(averageRating);
 }

 @Override
public List<Movie> getTop10Movies() {
    return movieRepository.findTop10ByOrderByAverageRatingDesc();

 }

 @Override
public List<Movie> getRecentlyReleasedMovie() {
    return movieRepository.findTop10ByOrderByReleaseDateDesc();

 }

}
