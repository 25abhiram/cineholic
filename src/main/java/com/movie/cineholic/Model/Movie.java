package com.movie.cineholic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String movieId;
    private String title;
    private String releaseDate;
    private String trailerLink; //youtube link of movie trailer
    private String poster_path; //images from website
    private List<String> genres;
    private String runtime;
    private String budget;
    private String revenue;
    private String description;
    private double averageRating;
    @DocumentReference
    private List<Review> reviewIds;


}
