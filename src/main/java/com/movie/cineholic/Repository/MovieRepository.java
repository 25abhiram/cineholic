package com.movie.cineholic.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.cineholic.Model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByGenre(String genre); 
    List<Movie> findByTitleContainingIgnoreCase(String title);
    List<Movie> findByAverageRatingGreaterThan(double rating);  
    
}

