package com.movie.cineholic.service.impl;

import com.movie.cineholic.model.Movie;
import com.movie.cineholic.model.Recommendation;
import com.movie.cineholic.repository.MovieRepository;
import com.movie.cineholic.repository.RecommendationRepository;
import com.movie.cineholic.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;


    @Override
    public Recommendation addRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation); 
    }

    @Override
    public List<Recommendation> getRecommendationsByUserId(String userId) {
        return recommendationRepository.findByUserId(userId); 
    }

}
