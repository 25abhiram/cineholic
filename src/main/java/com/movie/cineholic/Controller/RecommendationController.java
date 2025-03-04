package com.movie.cineholic.Controller;

import com.movie.cineholic.Model.Movie;
import com.movie.cineholic.Model.Recommendation;
import com.movie.cineholic.Model.User;
import com.movie.cineholic.Service.MovieService;
import com.movie.cineholic.Service.RecommendationService;
import com.movie.cineholic.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    private static final Logger logger = Logger.getLogger(RecommendationController.class.getName());

    /**
     * Generate and return recommendations for a user based on their preferences (genres).
     */
    @GetMapping("/{userId}")
    public ResponseEntity<List<Movie>> getRecommendationsByUserId(@PathVariable String userId) {
        // Fetch the user details
        User user = userService.getUserById(userId);
        if (user == null) {
            logger.warning("User not found: " + userId);
            return ResponseEntity.notFound().build();
        }

        List<String> genrePreferences = user.getPreferences(); // User's preferred genres
        if (genrePreferences == null || genrePreferences.isEmpty()) {
            logger.warning("No preferences set for user: " + userId);
            return ResponseEntity.badRequest().build(); // No preferences set
        }

        // Collect top-rated movies for each genre preference
        List<Movie> recommendedMovies = new ArrayList<>();
        for (String genres : genrePreferences) {
            recommendedMovies.addAll(
                    movieService.getMoviesByGenres(genres).stream()
                            .sorted((m1, m2) -> Double.compare(m2.getAverageRating(), m1.getAverageRating()))
                            .limit(3) // Limit to top 3 movies per genre
                            .collect(Collectors.toList())
            );
        }

        // If no movies found for preferences
        if (recommendedMovies.isEmpty()) {
            logger.info("No movies found for user preferences: " + userId);
            return ResponseEntity.noContent().build();
        }

        // Save or update recommendations in the database
        List<Recommendation> recommendations = recommendationService.getRecommendationsByUserId(userId);
        Recommendation recommendation = recommendations.isEmpty() ? null : recommendations.get(0);
        if (recommendation == null) {
            recommendation = new Recommendation();
            recommendation.setUserId(userId);
        }
        recommendation.setRecommendedMovies(recommendedMovies.stream().map(Movie::getMovieId).collect(Collectors.toList()));
        recommendationService.saveRecommendation(recommendation);
        logger.info("Recommendations saved for user: " + userId);

        return ResponseEntity.ok(recommendedMovies);
    }
}