package dev.rajnish.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.BookMyShow.dto.BookTicketRequestDTO;
import dev.rajnish.BookMyShow.model.Ticket;
import dev.rajnish.BookMyShow.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;
    
    @PostMapping("/ticket")
    public ResponseEntity postMethodName(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) throws Exception {
        //TODO: process POST request
        Ticket ticket = ticketService.bookTicket(bookTicketRequestDTO.getShowSeatIds());        
        return ResponseEntity.ok(ticket);
    }
    
}
