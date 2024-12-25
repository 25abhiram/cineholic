package com.movie.cineholic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.cineholic.Model.Theatre;
import com.movie.cineholic.Service.TheatreService;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @PostMapping
    public ResponseEntity<Theatre> createTheatre(@RequestBody Theatre theatre) {
        Theatre createdTheatre = this.theatreService.createTheatre(theatre);
        return ResponseEntity.ok(createdTheatre);
    }

    @GetMapping("/{theatreId}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable String theatreId) {
        Theatre theatre = this.theatreService.getTheatreById(theatreId);
        return theatre != null ? ResponseEntity.ok(theatre) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        List<Theatre> theatres = this.theatreService.getAllTheatres();
        return ResponseEntity.ok(theatres);
    }

    @PutMapping("/{theatreId}")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable String theatreId, @RequestBody Theatre theatre) {
        Theatre updateTheatre = this.theatreService.updateTheatre(theatreId, theatre);
        return updateTheatre != null ? ResponseEntity.ok(theatre) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{theatreId}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable String theatreId) {
        this.theatreService.deleteTheatre(theatreId);
        return ResponseEntity.noContent().build();
    }
}
