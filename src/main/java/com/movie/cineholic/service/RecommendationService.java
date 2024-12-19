package com.movie.cineholic.service;

import com.movie.cineholic.model.Recommendation;
import java.util.List;

public interface RecommendationService {
    Recommendation addRecommendation(Recommendation recommendation);
    List<Recommendation> getRecommendationsByUserId(String userId);
   
}
