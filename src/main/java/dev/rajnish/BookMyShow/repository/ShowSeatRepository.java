package dev.rajnish.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.rajnish.BookMyShow.model.ShowSeat;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {
    
}
