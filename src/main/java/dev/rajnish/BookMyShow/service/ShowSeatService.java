package dev.rajnish.BookMyShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.BookMyShow.model.ShowSeat;
import dev.rajnish.BookMyShow.repository.ShowSeatRepository;

@Service
public class ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeat(int showSeatId)
    {
        return showSeatRepository.getReferenceById(showSeatId);
    }
    
    public void saveShowSeat(ShowSeat showSeat)
    {
        showSeatRepository.save(showSeat);
    }
}
