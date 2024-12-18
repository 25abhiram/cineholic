package com.movie.cineholic.repository;

import com.movie.cineholic.model.Movie;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByGenre(String genre); 
    List<Movie> findByTitle(String title);
    List<Movie> findByAverageRatingGreaterThan(double rating);  
    
}

