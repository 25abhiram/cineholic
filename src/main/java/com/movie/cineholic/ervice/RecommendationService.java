package com.movie.cineholic.ervice;

import java.util.List;

import com.movie.cineholic.odel.Recommendation;

public interface RecommendationService {
    Recommendation addRecommendation(Recommendation recommendation);
    List<Recommendation> getRecommendationsByUserId(String userId);
   
}
