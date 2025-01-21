package dev.rajnish.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.BookMyShow.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/hello")
    public ResponseEntity greet()
    {
        String greet = ticketService.greet();
        return ResponseEntity.ok(greet);
    }    
}
