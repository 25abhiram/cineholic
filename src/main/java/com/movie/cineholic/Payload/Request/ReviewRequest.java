package com.movie.cineholic.Payload.Request;

import lombok.Data;

@Data
public class ReviewRequest {
    private String movieId;
    private String userId;
    private String username;
    private double rating;
    private String reviewText;
}
