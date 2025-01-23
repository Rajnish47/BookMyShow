package dev.rajnish.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.BookMyShow.dto.CityRequestDTO;
import dev.rajnish.BookMyShow.model.City;
import dev.rajnish.BookMyShow.service.CityService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO){
        try{
            String cityName = cityRequestDTO.getName();
            Integer pincode = cityRequestDTO.getPincode();
            if(cityName == null || cityName.isEmpty() || cityName.isBlank() || pincode==null) {
                throw new Exception("Invalid params");
            }

            City savedCity = cityService.saveCity(cityName,pincode);
            return ResponseEntity.ok(savedCity);
        }catch (Exception e){
            e.printStackTrace();
        }
         return null;
    }

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName)
    {
        try{
            if(cityName==null || cityName.isEmpty() || cityName.isBlank())
            {
                throw new Exception("Invalid city name");            
            }

            return ResponseEntity.ok(cityService.getCityByName(cityName));            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }    
}
