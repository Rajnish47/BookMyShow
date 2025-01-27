package dev.rajnish.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.BookMyShow.model.City;
import dev.rajnish.BookMyShow.model.Theater;
import dev.rajnish.BookMyShow.repository.TheaterRepository;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private CityService cityService;

    public Theater addTheater(String name,String address,int cityId)
    {
        Theater theater = new Theater(name,address);
        Theater savedTheater = theaterRepository.save(theater);

        City city = cityService.getCityById(cityId);
        List<Theater> theaters = city.getTheaters();
        theaters.add(savedTheater);
        city.setTheaters(theaters);
        cityService.saveCity(city);

        return savedTheater;
    }

    public Theater updateTheaterDetails(Theater theater)
    {
        return theaterRepository.save(theater);
    }

    public Theater getTheater(int id)
    {
        return theaterRepository.findById(id).get();
    }
    
    public void removeTheater(int cityId,int theaterId)
    {
        City city = cityService.getCityById(cityId);
        List<Theater> theaters = city.getTheaters();
        if(theaters!=null)
        {
            Theater theater = getTheater(theaterId);
            theaters.remove(theater);
            city.setTheaters(theaters);
            cityService.saveCity(city);
            theaterRepository.deleteById(theaterId);
        }
    }
}
