package dev.rajnish.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.BookMyShow.model.Auditorium;
import dev.rajnish.BookMyShow.model.Theater;
import dev.rajnish.BookMyShow.model.constant.AuditoriumFeatures;
import dev.rajnish.BookMyShow.repository.AuditoriumRepository;

@Service
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private TheaterService theaterService;

    public Auditorium addAuditorium(int theaterId,String name,int capacity,List<String> audiFeatures)
    {
        List<AuditoriumFeatures> auditoriumFeatures = new ArrayList<>();
        for(String feature:audiFeatures)
        {
            if(feature.equals("2D"))
            {
                auditoriumFeatures.add(AuditoriumFeatures.TWO_D);
            }
            else
            if(feature.equals("3D"))
            {
                auditoriumFeatures.add(AuditoriumFeatures.THREE_D);
            }
            else
            if(feature.equals("IMAX"))
            {
                auditoriumFeatures.add(AuditoriumFeatures.IMAX);
            }
            else
            if(feature.equals("DOLBY"))
            {
                auditoriumFeatures.add(AuditoriumFeatures.DOLBY);
            }
        }

        Auditorium auditorium = auditoriumRepository.save(new Auditorium(name, capacity, auditoriumFeatures));
        Theater theater = theaterService.getTheater(theaterId);
        List<Auditorium> auditoriums = theater.getAuditoriums();
        if(auditoriums==null)
        {
            auditoriums=new ArrayList<>();
        }
        auditoriums.add(auditorium);
        theater.setAuditoriums(auditoriums);
        theaterService.updateTheaterDetails(theater);

        return auditorium;        
    }

    public Auditorium getAuditoriumById(int id)
    {
        return auditoriumRepository.findById(id).get();
    }

    public Auditorium updateAuditoriumSpecs(Auditorium auditorium)
    {
        return auditoriumRepository.save(auditorium);
    }

    public void deleteAuditorium(int id)
    {
        auditoriumRepository.deleteById(id);
    }
    
}
