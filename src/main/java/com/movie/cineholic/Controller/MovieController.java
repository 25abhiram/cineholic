package com.movie.cineholic.Controller;

import com.movie.cineholic.Model.Movie;
import com.movie.cineholic.Service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies=this.movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie addedMovie=this.movieService.addMovie(movie);
        return ResponseEntity.ok(addedMovie);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String movieId){
        Optional<Movie> movie=this.movieService.getMovieById(movieId);
        return ResponseEntity.ok(movie);
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

    @GetMapping("/genre/{genres}")
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


    @GetMapping("/averageRating/{averageRating}")
    public ResponseEntity<List<Movie>> getMoviesWithRatingAbove(@PathVariable double averageRating) {
        List<Movie> movies = movieService.getMoviesWithRatingAbove(averageRating);
        return movies.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(movies);
    }


     // Endpoint to get the top 5 movies
     @GetMapping("/top10")
     public ResponseEntity<List<Movie>> getTop10Movies() {
         List<Movie> movies = movieService.getTop10Movies();
         return ResponseEntity.ok(movies);

    }  
    @GetMapping("/recent")
    public ResponseEntity<List<Movie>> getRecentlyReleasedMovie() {
        List <Movie> movies = movieService.getRecentlyReleasedMovie();
        return ResponseEntity.ok(movies);
    }
    
}