package com.movie.cineholic.service;
import com.movie.cineholic.model.Review;

import java.util.List;

public interface ReviewService {
    Review addReview(Review review);
    Review updateReview(String reviewId, Review updatedReview);
    void deleteReview(String reviewId);
     List<Review> getReviewsByMovieId(String movieId);
     List<Review> getReviewsByUserId(String userId);
}
