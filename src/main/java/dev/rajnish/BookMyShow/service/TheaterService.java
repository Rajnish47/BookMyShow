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
        Theater theater = new Theater();
        theater.setName(name);
        theater.setAddress(address);
        Theater savedTheater = theaterRepository.save(theater);

        City city = cityService.getCityById(cityId);
        List<Theater> theaters = city.getTheaters();
        theaters.add(savedTheater);
        city.setTheaters(theaters);
        cityService.saveCity(city);

        return savedTheater;
    }    
}
