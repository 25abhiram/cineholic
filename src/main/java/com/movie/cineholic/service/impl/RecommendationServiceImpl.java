package com.movie.cineholic.Service.impl;

import com.movie.cineholic.Model.Movie;
import com.movie.cineholic.Model.Recommendation;
import com.movie.cineholic.Repository.MovieRepository;
import com.movie.cineholic.Repository.RecommendationRepository;
import com.movie.cineholic.Service.RecommendationService;

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
