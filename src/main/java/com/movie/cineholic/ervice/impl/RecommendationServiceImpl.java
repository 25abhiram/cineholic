package com.movie.cineholic.ervice.impl;

import com.movie.cineholic.epository.MovieRepository;
import com.movie.cineholic.epository.RecommendationRepository;
import com.movie.cineholic.ervice.RecommendationService;
import com.movie.cineholic.odel.Movie;
import com.movie.cineholic.odel.Recommendation;

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
