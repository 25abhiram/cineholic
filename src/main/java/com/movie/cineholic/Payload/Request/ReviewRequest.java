package com.movie.cineholic.Payload.Request;

import lombok.Data;

@Data
public class ReviewRequest {
    private String movieId;
    private double rating;
    private String reviewText;
}
