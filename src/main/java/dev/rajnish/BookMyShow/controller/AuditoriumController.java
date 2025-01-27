package dev.rajnish.BookMyShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.BookMyShow.dto.AuditoriumRequestDTO;
import dev.rajnish.BookMyShow.exception.InvalidDetailsException;
import dev.rajnish.BookMyShow.model.Auditorium;
import dev.rajnish.BookMyShow.service.AuditoriumService;

@RestController
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @PostMapping("/auditorium")
    public ResponseEntity addAuditorium(@RequestBody AuditoriumRequestDTO auditoriumRequestDTO)
    {
        if(auditoriumRequestDTO.getTheaterId()<=0)
        {
            throw new InvalidDetailsException("Invalid theater id");
        }

        String audiName = auditoriumRequestDTO.getName();
        int capacity = auditoriumRequestDTO.getCapacity();
        List<String> audiFeatures = auditoriumRequestDTO.getAuditoriumFeatures();

        if(audiName==null || audiName.isBlank() || audiName.isEmpty())
        {
            throw new InvalidDetailsException("Invalid audi name");
        }

        if(capacity<=0)
        {
            throw new InvalidDetailsException("Invalid capacity");
        }

        for(String feature:audiFeatures)
        {
            if(!feature.equals("DOLBY") && !feature.equals("IMAX") && !feature.equals("2D") && !feature.equals("3D"))
            {
                throw new InvalidDetailsException("Invalid audi features");
            }
        }

        Auditorium savedAuditorium = auditoriumService.addAuditorium(auditoriumRequestDTO.getTheaterId(), audiName, capacity, audiFeatures);
        return ResponseEntity.ok(savedAuditorium);
    }

    @DeleteMapping("/audi/delete/{id}")
    public ResponseEntity deleteAuditorium(@PathVariable("id") int auditoriumId)
    {
        if(auditoriumId<=0)
        {
            throw new InvalidDetailsException("Invalid audi id");
        }

        auditoriumService.deleteAuditorium(auditoriumId);

        return ResponseEntity.ok("Audi has been deleted");
    }
    
}
