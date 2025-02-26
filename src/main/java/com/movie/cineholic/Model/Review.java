package com.movie.cineholic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviews")
public class Review {

    @Id
    private String reviewId;
    private String movieId;
    private String userId;
    private String username;
    private double rating;
    private String reviewText;
    private LocalDateTime timeStamp = LocalDateTime.now();

    public Review(String movieId, String userId, String username, double rating, String reviewText) {
        this.movieId = movieId;
        this.userId = userId;
        this.username = username;
        this.rating = rating;
        this.reviewText = reviewText;
    }
}
