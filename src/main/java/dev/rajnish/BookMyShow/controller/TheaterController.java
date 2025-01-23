package dev.rajnish.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.BookMyShow.dto.TheaterRequestDTO;
import dev.rajnish.BookMyShow.model.Theater;
import dev.rajnish.BookMyShow.service.TheaterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/theater")    
    public ResponseEntity addTheater(@RequestBody TheaterRequestDTO theaterRequestDTO)
    {
        try{
            String name = theaterRequestDTO.getName();
            String address = theaterRequestDTO.getAddress();
            int cityId = theaterRequestDTO.getCityId();

            if(name==null || name.isEmpty() || name.isBlank() || address==null || address.isEmpty() || address.isBlank() || cityId<=0)
            {
                throw new Exception("Invalid theater details");
            }

           return ResponseEntity.ok(theaterService.addTheater(name, address,cityId));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    
}
