package com.movie.cineholic.epository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.cineholic.Model.Recommendation;

import java.util.List;

public interface RecommendationRepository extends MongoRepository<Recommendation, String> {

    List<Recommendation> findByUserId(String userId); 
}
