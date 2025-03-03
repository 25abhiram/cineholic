package com.movie.cineholic.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.movie.cineholic.Model.Recommendation;
import java.util.List;

@Repository
public interface RecommendationRepository extends MongoRepository<Recommendation, String> {
    List<Recommendation> findByUserId(String userId); // To fetch recommendations for a specific user
}
