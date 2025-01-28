package com.movie.cineholic.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.cineholic.Model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByGenres(String genre);

    List<Movie> findByTitle(String title);

    List<Movie> findByAverageRatingGreaterThan(double rating);

}
