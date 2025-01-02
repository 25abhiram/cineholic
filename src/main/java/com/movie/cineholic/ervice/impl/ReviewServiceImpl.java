package com.movie.cineholic.ervice.impl;
import com.movie.cineholic.epository.ReviewRepository;
import com.movie.cineholic.ervice.ReviewService;
import com.movie.cineholic.odel.Review;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

   @Override
    public Review updateReview(String reviewId,Review review) {
        if(reviewRepository.existsById(reviewId)) {
            review.setReviewId(reviewId);
        }
        return reviewRepository.save(review);
    }


    @Override
    public void deleteReview(String reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public List<Review> getReviewsByMovieId(String movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    @Override
    public List<Review> getReviewsByUserId(String userId) {
        return reviewRepository.findByUserId(userId);
    }
}
