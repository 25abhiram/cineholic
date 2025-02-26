package com.movie.cineholic.Controller;

import com.movie.cineholic.Model.Review;
import com.movie.cineholic.Payload.Request.ReviewRequest;
import com.movie.cineholic.Service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Review> addReview(@RequestBody ReviewRequest reviewRequest) {
        return new ResponseEntity<>(reviewService.addReview(reviewRequest.getMovieId(),reviewRequest.getUserId(),reviewRequest.getUsername(),reviewRequest.getRating(),reviewRequest.getReviewText()),HttpStatus.CREATED);
    }

    @PutMapping("/{reviewId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Review> updateReview(@PathVariable String reviewId, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(reviewId, review);
        return updatedReview != null ? ResponseEntity.ok(updatedReview) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{reviewId}")
    @PreAuthorize("isAuthenticated()")
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

    @GetMapping("/{movieId}/{userId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Review> getUserReviewForMovie(@PathVariable String movieId, @PathVariable String userId) {
        Optional<Review> review = reviewService.getUserReviewForMovie(movieId, userId);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
