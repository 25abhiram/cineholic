package com.movie.cineholic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviews") // MongoDB collection name
public class Review {

    @Id
    private String reviewId; // Unique identifier for the review
    private String movieId;  // ID of the associated movie
    private String userId;   // ID of the user who wrote the review
    private double rating;   // Rating given to the movie
    private String reviewText; // Text content of the review
    private LocalDateTime timeStamp; // When the review was created/updated
}
