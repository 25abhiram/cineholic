package com.movie.cineholic.Service;

import java.util.List;

import com.movie.cineholic.Model.Recommendation;

public interface RecommendationService {
    Recommendation addRecommendation(Recommendation recommendation);
    List<Recommendation> getRecommendationsByUserId(String userId);
   
}
