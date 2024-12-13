package com.movie.cineholic.controller;


import com.movie.cineholic.model.Movie;
import com.movie.cineholic.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies=this.movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie addedMovie=this.movieService.addMovie(movie);
        return ResponseEntity.ok(addedMovie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id){
        Movie movie=this.movieService.getMovieById(id);
        return movie!=null?ResponseEntity.ok(movie):ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String id,@RequestBody Movie movie) {
        Movie updatedMovie=this.movieService.updateMovie(id, movie);
        return updatedMovie!=null?ResponseEntity.ok(updatedMovie):ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String id) {
       this.movieService.deleteMovie(id);
       return ResponseEntity.noContent().build();
    }
}
