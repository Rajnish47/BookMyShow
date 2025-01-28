package dev.rajnish.BookMyShow.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.BookMyShow.dto.ShowRequestDTO;
import dev.rajnish.BookMyShow.exception.InvalidDetailsException;
import dev.rajnish.BookMyShow.service.ShowService;

@RestController
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/show")
    public ResponseEntity addShow(@RequestBody ShowRequestDTO showRequestDTO)
    {
        LocalDateTime startTime = showRequestDTO.getStartDateTime();
        LocalDateTime endTime = showRequestDTO.getEndDateTime();
        int movieId = showRequestDTO.getMovieId();
        int audiId = showRequestDTO.getAuditoriumId();
        List<Integer> seatIds = showRequestDTO.getShowSeatsIds();

        if(movieId<=0 || audiId<=0)
        {
            throw new InvalidDetailsException("Invalid movie or audi id");
        }

        for(Integer seatId:seatIds)
        {
            if(seatId<=0)
            {
                throw new InvalidDetailsException("Invalid seat id");
            }
        }

        return ResponseEntity.ok(showService.addShow(startTime, endTime, audiId, movieId, seatIds));
    }    
}
