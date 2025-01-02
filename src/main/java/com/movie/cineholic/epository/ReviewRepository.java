package com.movie.cineholic.epository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.cineholic.odel.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByMovieId(String movieId); // Find reviews by movie
    List<Review> findByUserId(String userId);   // Find reviews by user
}
