package dev.rajnish.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.BookMyShow.model.City;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    public City findCityByName(String name);    
}
