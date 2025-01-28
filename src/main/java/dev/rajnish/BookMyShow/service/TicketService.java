package dev.rajnish.BookMyShow.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dev.rajnish.BookMyShow.model.Show;
import dev.rajnish.BookMyShow.model.ShowSeat;
import dev.rajnish.BookMyShow.model.Ticket;
import dev.rajnish.BookMyShow.model.constant.ShowSeatStatus;
import dev.rajnish.BookMyShow.model.constant.TicketStatus;
import dev.rajnish.BookMyShow.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private ShowSeatService showSeatService;

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket bookTicket(List<Integer> showSeatIds) throws Exception
    {
        checkAndLockSeats(showSeatIds);
        return startPayment(showSeatIds);      
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void checkAndLockSeats(List<Integer> showSeatIds) throws Exception
    {
        for(Integer showSeatId: showSeatIds)
        {
            ShowSeat showSeat = showSeatService.getShowSeat(showSeatId);
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                throw new Exception("Seat is not available");
            }
        }
        
        for(Integer showSeatId: showSeatIds)
        {
            ShowSeat showSeat = showSeatService.getShowSeat(showSeatId);
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(showSeat);
        }
    }

    public Ticket startPayment(List<Integer> showSeatIds)
    {
        int totalAmount = 0;
        List<ShowSeat> showSeats = new ArrayList<>();
        for(Integer showSeatId: showSeatIds)
        {
            ShowSeat showSeat = showSeatService.getShowSeat(showSeatId);
            showSeats.add(showSeat);
            totalAmount = totalAmount+showSeat.getPrice();
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeatService.saveShowSeat(showSeat);
        }

        ShowSeat showSeat = showSeatService.getShowSeat(showSeatIds.get(0));
        Show show = showSeat.getShow();
        Ticket ticket = new Ticket();
        ticket.setAmount(totalAmount);
        ticket.setTimeOfBooking(LocalDateTime.now());
        ticket.setShow(show);
        ticket.setShowSeats(showSeats);
        ticket.setTicketStatus(TicketStatus.BOOKED);

        ticketRepository.save(ticket);
        
        return ticket;
    }
    
}
