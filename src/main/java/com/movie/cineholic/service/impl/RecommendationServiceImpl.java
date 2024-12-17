package com.movie.cineholic.service.impl;

import com.movie.cineholic.model.Recommendation;
import com.movie.cineholic.repository.RecommendationRepository;
import com.movie.cineholic.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public Recommendation addRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation); // Save recommendation to MongoDB
    }

    @Override
    public List<Recommendation> getRecommendationsByUserId(String userId) {
        return recommendationRepository.findByUserId(userId); // Fetch recommendations for specific userId
    }
}
