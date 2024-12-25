package com.movie.cineholic.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.cineholic.Model.Theatre;
import com.movie.cineholic.Repository.TheatreRepository;
import com.movie.cineholic.Service.TheatreService;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    @Override
    public Theatre getTheatreById(String theatreId) {
        Optional<Theatre> theatre = theatreRepository.findById(theatreId);
        return theatre.orElse(null);
    }

    @Override
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    @Override
    public Theatre updateTheatre(String theatreId, Theatre theatre) {
        if (theatreRepository.existsById(theatreId)) {
            theatre.setTheatreId(theatreId);
            return theatreRepository.save(theatre);
        }
        return null;
    }

    @Override
    public void deleteTheatre(String theatreId) {
        theatreRepository.deleteById(theatreId);
    }

}
