package dev.rajnish.BookMyShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.BookMyShow.model.City;
import dev.rajnish.BookMyShow.repository.CityRepository;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public City saveCity(String name,int pincode)
    {
        City city = new City();
        city.setName(name);
        city.setPincode(pincode);
        return cityRepository.save(city);        
    }
    
}
