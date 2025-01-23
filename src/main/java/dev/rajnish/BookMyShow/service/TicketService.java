package dev.rajnish.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dev.rajnish.BookMyShow.model.ShowSeat;
import dev.rajnish.BookMyShow.model.Ticket;
import dev.rajnish.BookMyShow.model.constant.ShowSeatStatus;

@Service
public class TicketService {

    @Autowired
    private ShowSeatService showSeatService;

    public String greet()
    {
        return "Hello World";
    }

    public Ticket bookTicket(List<Integer> showSeatIds) throws Exception
    {
        checkAndLockSeats(showSeatIds);
        startPayment(showSeatIds);
        return new Ticket();        
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

    public boolean startPayment(List<Integer> showSeatIds)
    {
        return true;
    }
    
}
