package com.movie.cineholic.odel;

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
    private double rating;  
    private String reviewText; 
    private LocalDateTime timeStamp; 
}
