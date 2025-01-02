package com.movie.cineholic.odel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "recommendations")
public class Recommendation {

    @Id
    private String recommendationId; 
    private String userId;           
    private List<String> recommendedMovies;  

    
}
