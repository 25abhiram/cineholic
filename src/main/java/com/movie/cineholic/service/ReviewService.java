package com.movie.cineholic.Service;
import java.util.List;

import com.movie.cineholic.Model.Review;

public interface ReviewService {
    Review addReview(Review review);
    Review updateReview(String reviewId, Review updatedReview);
    void deleteReview(String reviewId);
     List<Review> getReviewsByMovieId(String movieId);
     List<Review> getReviewsByUserId(String userId);
}
