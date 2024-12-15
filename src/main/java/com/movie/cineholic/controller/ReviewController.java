package com.movie.cineholic.controller;

import com.movie.cineholic.model.Review;
import com.movie.cineholic.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        review.setTimeStamp(LocalDateTime.now());
        return ResponseEntity.ok(reviewService.addReview(review));
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable String reviewId, @RequestBody Review review) {
        review.setTimeStamp(LocalDateTime.now());
        return ResponseEntity.ok(reviewService.updateReview(reviewId, review));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable String reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Review>> getReviewsByMovieId(@PathVariable String movieId) {
        List<Review> reviews = reviewService.getReviewsByMovieId(movieId);
        return reviews.isEmpty() 
                ? ResponseEntity.notFound().build() 
                : ResponseEntity.ok(reviews);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUserId(@PathVariable String userId) {
        List<Review> reviews = reviewService.getReviewsByUserId(userId);
        return reviews.isEmpty() 
                ? ResponseEntity.notFound().build() 
                : ResponseEntity.ok(reviews);
    }
}
