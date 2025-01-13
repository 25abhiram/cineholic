package com.movie.cineholic.Controller;

import com.movie.cineholic.Model.Recommendation;
import com.movie.cineholic.Service.RecommendationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recommendations") 
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping
    public ResponseEntity<Recommendation> addRecommendation(@RequestBody Recommendation recommendation) {
        Recommendation createdRecommendation = recommendationService.addRecommendation(recommendation);
        return ResponseEntity.status(201).body(createdRecommendation);  
    }

    
    @GetMapping("/{userId}")
    public ResponseEntity<List<Recommendation>> getRecommendationsByUserId(@PathVariable String userId) {
        List<Recommendation> recommendations = recommendationService.getRecommendationsByUserId(userId);
        if (recommendations.isEmpty()) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(recommendations);
    }
}
