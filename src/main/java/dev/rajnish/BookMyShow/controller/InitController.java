package dev.rajnish.BookMyShow.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @GetMapping("/time")
    public ResponseEntity getTime()
    {
        return ResponseEntity.ok(LocalDateTime.now());
    }
    
}
