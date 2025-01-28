package dev.rajnish.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.BookMyShow.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
    
}
