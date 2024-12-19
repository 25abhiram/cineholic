package com.movie.cineholic.repository;

import com.movie.cineholic.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByMovieId(String movieId); // Find reviews by movie
    List<Review> findByUserId(String userId);   // Find reviews by user
}
