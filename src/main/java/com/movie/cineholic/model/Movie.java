package com.movie.cineholic.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode
public class Movie {
    @Id
    private String id;
    private String title;
    private String genre;
    private String description;
    private double averageRating;
    private String review;
}
