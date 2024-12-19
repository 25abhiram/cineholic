package com.movie.cineholic.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.cineholic.Model.Theatre;

@Repository
public interface TheatreRepository extends MongoRepository<Theatre,String>{

}
