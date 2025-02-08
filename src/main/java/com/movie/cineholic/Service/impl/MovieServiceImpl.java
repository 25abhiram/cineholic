package com.movie.cineholic.Service.impl;

import com.movie.cineholic.Model.Movie;
import com.movie.cineholic.Repository.MovieRepository;
import com.movie.cineholic.Service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Movie updateMovie(String movieId,Movie movie) {
        if(movieRepository.existsById(movieId)) {
            movie.setMovieId(movieId);
        }
        return movieRepository.save(movie);
    }


    @Override
    public void deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);

    }

    @Override
    public Movie getMovieById(String movieId) {
    return movieRepository.findById(movieId)
            .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + movieId));
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
public List<Movie> getMoviesWithRatingAbove(double rating) {
    return movieRepository.findByAverageRatingGreaterThan(rating);
 }

}
