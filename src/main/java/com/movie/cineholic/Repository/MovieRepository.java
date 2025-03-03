package com.movie.cineholic.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.cineholic.Model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByGenresContainingIgnoreCase(String genres); 
    List<Movie> findByTitleContainingIgnoreCase(String title);
    List<Movie> findByAverageRatingGreaterThan(double averageRating);  

    // ✅ Get top 5 movies sorted by rating (descending order)
    List<Movie> findTop10ByOrderByAverageRatingDesc();
   List<Movie> findTop10ByOrderByReleaseDateDesc(); // Fetch the latest released movie
    
}

