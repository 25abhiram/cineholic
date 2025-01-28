package com.movie.cineholic.Service.impl;
import com.movie.cineholic.Model.Movie;
import com.movie.cineholic.Model.Review;
import com.movie.cineholic.Repository.ReviewRepository;
import com.movie.cineholic.Service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // private final ReviewRepository reviewRepository;

    // public ReviewServiceImpl(ReviewRepository reviewRepository) {
    //     this.reviewRepository = reviewRepository;
    // }

    @Override
    public Review addReview(String movieId,double rating,String reviewText) {
        Review review=new Review(movieId,rating,reviewText);
        reviewRepository.insert(review);

        mongoTemplate.update(Movie.class)
        .matching(Criteria.where("movieId").is(movieId))
        .apply(new Update().push("reviewIds").value(review)).first();
        return review;
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
