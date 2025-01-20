package dev.rajnish.BookMyShow.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Actor {

    private String name;
    @ManyToMany
    private List<Movie> staredMovies;    
}
