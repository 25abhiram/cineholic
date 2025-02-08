package com.movie.cineholic.Controller;

import com.movie.cineholic.Model.Movie;
import com.movie.cineholic.Service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies=this.movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie addedMovie=this.movieService.addMovie(movie);
        return ResponseEntity.ok(addedMovie);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String movieId){
        Movie movie=this.movieService.getMovieById(movieId);
        return movie!=null?ResponseEntity.ok(movie):ResponseEntity.notFound().build();
    }


    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String movieId,@RequestBody Movie movie) {
        Movie updatedMovie=this.movieService.updateMovie(movieId, movie);
        return updatedMovie!=null?ResponseEntity.ok(updatedMovie):ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String movieId) {
       this.movieService.deleteMovie(movieId);
       return ResponseEntity.noContent().build();
    }

    @GetMapping("/genres/{genres}")
    public ResponseEntity<List<Movie>> getMoviesByGenres(@PathVariable String genres) {
        List<Movie> movies = movieService.getMoviesByGenres(genres);

        return (movies != null && !movies.isEmpty())
            ? ResponseEntity.ok(movies)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.getMoviesByTitle(title);

        return (movies != null && !movies.isEmpty())
            ? ResponseEntity.ok(movies)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/rating/above")
    public ResponseEntity<List<Movie>> getMoviesWithRatingAbove(@RequestParam double rating) {
        List<Movie> movies = movieService.getMoviesWithRatingAbove(rating);
        return movies.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(movies);
    }

}
