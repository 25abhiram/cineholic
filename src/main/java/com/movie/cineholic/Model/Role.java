package com.movie.cineholic.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "roles")
@Data
public class Role {
    @Id
    private String id;
    private UserRole name;

    public Role() {
    }

    public Role(UserRole name) {
        this.name = name;
    }
}
