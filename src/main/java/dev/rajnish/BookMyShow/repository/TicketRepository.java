package dev.rajnish.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.BookMyShow.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer>  {
    
}
