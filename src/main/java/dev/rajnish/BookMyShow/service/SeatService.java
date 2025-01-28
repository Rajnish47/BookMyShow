package dev.rajnish.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.BookMyShow.exception.MaxCapacityReachedException;
import dev.rajnish.BookMyShow.model.Auditorium;
import dev.rajnish.BookMyShow.model.Seat;
import dev.rajnish.BookMyShow.model.constant.SeatStatus;
import dev.rajnish.BookMyShow.model.constant.SeatType;
import dev.rajnish.BookMyShow.repository.SeatRepository;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired AuditoriumService auditoriumService;

    public Seat addSeat(int audiId,int row,int col,String seatNo,SeatType seatType,SeatStatus seatStatus)
    {
        Seat seat = new Seat();
        seat.setCol(col);
        seat.setRow(row);
        seat.setSeatNumber(seatNo);
        seat.setSeatType(seatType);
        seat.setSeatStatus(seatStatus);

        Seat savedSeat = seatRepository.save(seat);
        Auditorium auditorium = auditoriumService.getAuditoriumById(audiId);

        //TODO: change  if else to ternary operator here and other places
        List<Seat> seats = auditorium.getSeats();
        if(seats==null)
        {
            seats = new ArrayList<>();
        }

        if(seats.size()==auditorium.getCapacity())
        {
            throw new MaxCapacityReachedException("Auditorium capacity reached");
        }

        seats.add(savedSeat);
        auditorium.setSeats(seats);
        auditoriumService.updateAuditoriumSpecs(auditorium);

        return savedSeat;        
    }    
}
