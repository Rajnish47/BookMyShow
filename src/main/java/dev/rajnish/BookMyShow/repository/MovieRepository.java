package dev.rajnish.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.BookMyShow.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    public Movie findMovieByName(String name);    
}
