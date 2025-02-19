package com.movie.cineholic.Service.impl;

import com.movie.cineholic.Model.Movie;
import com.movie.cineholic.Model.Review;
import com.movie.cineholic.Repository.MovieRepository;
import com.movie.cineholic.Repository.ReviewRepository;
import com.movie.cineholic.Service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // private final ReviewRepository reviewRepository;

    // public ReviewServiceImpl(ReviewRepository reviewRepository) {
    // this.reviewRepository = reviewRepository;
    // }

    @Override
    public Review addReview(String movieId, String userId,String username, double rating, String reviewText) {
        // Check if the user has already reviewed this movie
        Optional<Review> existingReview = reviewRepository.findByMovieIdAndUserId(movieId, userId);
        if (existingReview.isPresent()) {
            return null; // User has already reviewed the movie
        }
        Review review = new Review(movieId, userId,username, rating, reviewText);
        reviewRepository.insert(review);

        // Update the review list for the movie
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("movieId").is(movieId))
                .apply(new Update().push("reviewIds").value(review)).first();

        // Update movie's average rating
        updateMovieAverageRating(movieId);
        return review;
    }

    @Override
    public Review updateReview(String reviewId, Review updatedReview) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review existingReview = optionalReview.get();
            existingReview.setRating(updatedReview.getRating());
            existingReview.setReviewText(updatedReview.getReviewText());
            existingReview.setTimeStamp(updatedReview.getTimeStamp());

            Review savedReview = reviewRepository.save(existingReview);

            // Update movie's average rating
            updateMovieAverageRating(existingReview.getMovieId());

            return savedReview;
        }
        return null;
    }

    @Override
    public void deleteReview(String reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            reviewRepository.deleteById(reviewId);

            // Update movie's average rating
            updateMovieAverageRating(review.getMovieId());
        }
    }

    @Override
    public List<Review> getReviewsByMovieId(String movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    @Override
    public List<Review> getReviewsByUserId(String userId) {
        return reviewRepository.findByUserId(userId);
    }

    private void updateMovieAverageRating(String movieId) {
        List<Review> reviews = reviewRepository.findByMovieId(movieId);

        double totalRating = reviews.stream().mapToDouble(Review::getRating).sum();
        double averageRating = reviews.isEmpty() ? 0 : totalRating / reviews.size();

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("movieId").is(movieId))
                .apply(new Update().set("averageRating", averageRating))
                .first();
    }

    @Override
    public Optional<Review> getUserReviewForMovie(String movieId, String userId) {
        return reviewRepository.findByMovieIdAndUserId(movieId, userId);
    }

}
