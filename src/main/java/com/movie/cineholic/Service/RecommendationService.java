package com.movie.cineholic.Service;

import com.movie.cineholic.Model.Recommendation;
import java.util.List;

public interface RecommendationService {
    Recommendation saveRecommendation(Recommendation recommendation);
    List<Recommendation> getRecommendationsByUserId(String userId);
}
