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
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenres(genre);
    }

    @Override
    public List<Movie> getMoviesByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> getMoviesWithRatingAbove(double rating) {
        return movieRepository.findByAverageRatingGreaterThan(rating);
    }

}
