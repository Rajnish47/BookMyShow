package dev.rajnish.BookMyShow.model;

import java.time.LocalDateTime;
import java.util.List;

import dev.rajnish.BookMyShow.model.constant.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {

    private LocalDateTime timeOfBooking;
    private double amount;

    @OneToMany
    private List<ShowSeat> showSeats;
    
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    
}
