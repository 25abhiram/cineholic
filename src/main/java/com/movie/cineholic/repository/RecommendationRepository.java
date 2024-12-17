package com.movie.cineholic.repository;

import com.movie.cineholic.model.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RecommendationRepository extends MongoRepository<Recommendation, String> {

    List<Recommendation> findByUserId(String userId); 
}
