package com.movie.cineholic.Service.impl;
import com.movie.cineholic.Model.Review;
import com.movie.cineholic.Repository.ReviewRepository;
import com.movie.cineholic.Service.ReviewService;

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
