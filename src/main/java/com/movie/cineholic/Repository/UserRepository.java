package com.movie.cineholic.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.cineholic.Model.User;
@Repository
public interface UserRepository extends MongoRepository<User,Long>{

}
