package com.movie.cineholic.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="theatres")
public class Theatre {
   @Id
    private String theatreId;
    private String theatreName;
    private String location;
    private String movieId;
    private String[] showtimes;
    private String startDate;
    private String endDate;
}
