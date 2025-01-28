package dev.rajnish.BookMyShow.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.BookMyShow.model.Auditorium;
import dev.rajnish.BookMyShow.model.Movie;
import dev.rajnish.BookMyShow.model.Show;
import dev.rajnish.BookMyShow.model.ShowSeat;
import dev.rajnish.BookMyShow.model.constant.ShowSeatStatus;
import dev.rajnish.BookMyShow.repository.ShowRepository;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired 
    private MovieService movieService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private ShowSeatService showSeatService;

    public Show addShow(LocalDateTime starTime,LocalDateTime endTime,int auditoriumId,int movieId,List<Integer> seatIds)
    {
        Show show = new Show();
        Auditorium auditorium = auditoriumService.getAuditoriumById(auditoriumId);
        Movie movie = movieService.getMovie(movieId);
        List<ShowSeat> showSeats = new ArrayList<>();

        show.setStartTime(starTime);
        show.setEndTime(endTime);
        show.setAuditorium(auditorium);
        show.setMovie(movie);

        Show savedShow = showRepository.save(show);
        List<Show> shows = auditorium.getShows();
        
        if(shows==null)
        {
            shows = new ArrayList<>();
        }

        shows.add(savedShow);
        auditorium.setShows(shows);
        auditoriumService.updateAuditoriumSpecs(auditorium);

        for(Integer seatId: seatIds)
        {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setPrice(600);
            showSeat.setSeat(seatService.getSeatById(seatId));
            showSeat.setShow(savedShow);
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);

            showSeatService.saveShowSeat(showSeat);
            showSeats.add(showSeat);
        }

        savedShow.setShowSeats(showSeats);
        showRepository.save(savedShow);
        
        return savedShow;
    }
    
}
