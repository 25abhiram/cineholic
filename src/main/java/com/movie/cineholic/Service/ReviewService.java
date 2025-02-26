package com.movie.cineholic.Service;

import java.util.List;
import java.util.Optional;

import com.movie.cineholic.Model.Review;

public interface ReviewService {
    Review addReview(String movieId, String userId,String username, double rating, String reviewText);

    Review updateReview(String reviewId, Review updatedReview);

    void deleteReview(String reviewId);

    List<Review> getReviewsByMovieId(String movieId);

    List<Review> getReviewsByUserId(String userId);

    // Add this method to check if a user has already reviewed a movie
    Optional<Review> getUserReviewForMovie(String movieId, String userId);
}
