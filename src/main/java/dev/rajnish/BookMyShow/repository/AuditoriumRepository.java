package dev.rajnish.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.BookMyShow.model.Auditorium;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Integer> {
    
}
