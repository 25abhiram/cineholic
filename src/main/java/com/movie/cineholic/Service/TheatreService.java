package com.movie.cineholic.Service;

import java.util.List;

import com.movie.cineholic.Model.Theatre;

public interface TheatreService {
Theatre createTheatre(Theatre theatre);
Theatre getTheatreById(String theatreId);
List<Theatre> getAllTheatres();
Theatre updateTheatre(String theatreId,Theatre theatre);
void deleteTheatre(String theatreId);
}
