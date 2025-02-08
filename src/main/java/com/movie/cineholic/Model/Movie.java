package com.movie.cineholic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String movieId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster_path;
    private String runTime;
    private String budget;
    private String revenue;
    private List<String> genres;
    private String description;
    private double averageRating;
    private List<String> reviews;




}
