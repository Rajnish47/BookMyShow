package dev.rajnish.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.BookMyShow.dto.SeatRequestDTO;
import dev.rajnish.BookMyShow.exception.InvalidDetailsException;
import dev.rajnish.BookMyShow.service.SeatService;

@RestController
public class SeatControlller {

    @Autowired
    private SeatService seatService;

    @PostMapping("/seat")
    public ResponseEntity addSeat(@RequestBody SeatRequestDTO seatRequestDTO)
    {
        String seatNo = seatRequestDTO.getSeatNo();
        if(seatRequestDTO.getAudiId()<=0)
        {
            throw new InvalidDetailsException("Invalid audi id");
        }

        if(seatRequestDTO.getCol()<0 || seatRequestDTO.getRow()<0)
        {
            throw new InvalidDetailsException("Invalid row or col");
        }

        if(seatNo==null || seatNo.isEmpty() || seatNo.isBlank())
        {
            throw new InvalidDetailsException("Invalid seat no");
        }

        return ResponseEntity.ok(seatService.addSeat(seatRequestDTO.getAudiId(), seatRequestDTO.getRow(), seatRequestDTO.getCol(), seatNo, seatRequestDTO.getSeatType(), seatRequestDTO.getSeatStatus()));
    }    
}
