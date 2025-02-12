package com.movie.cineholic.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.movie.cineholic.Model.Role;
import com.movie.cineholic.Model.UserRole;

public interface RoleRepository extends MongoRepository<Role,String>{
Optional<Role> findByName(UserRole name);
}
