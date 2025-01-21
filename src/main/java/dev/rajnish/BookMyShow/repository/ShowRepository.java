package dev.rajnish.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.BookMyShow.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
    
}
