package dev.rajnish.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.BookMyShow.dto.MovieRequestDTO;
import dev.rajnish.BookMyShow.service.MovieService;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
    public ResponseEntity addMovie(@RequestBody MovieRequestDTO movieRequestDTO)
    {
        String movieName = movieRequestDTO.getName();
        String movieDescription = movieRequestDTO.getDescription();

        try{
            if(movieName==null || movieName.isEmpty() || movieName.isBlank() || movieDescription==null ||movieDescription.isEmpty() || movieDescription.isBlank())
            {
                throw new Exception("Invalid movie details");
            }

            return ResponseEntity.ok(movieService.addMovie(movieName, movieDescription));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity getMovie(@PathVariable("id") int movieId)
    {
        try{
            if(movieId<=0)
            {
                throw new Exception("Invalid ID");
            }

            return ResponseEntity.ok(movieService.getMovie(movieId));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/movie/name/{name}")
    public ResponseEntity getMovie(@PathVariable("name") String movieName)
    {
        try{
            if(movieName==null || movieName.isEmpty() || movieName.isBlank())
            {
                throw new Exception("Invalid movie name");
            }

            return ResponseEntity.ok(movieService.getMovie(movieName));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @DeleteMapping("/movie/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") int movieId)
    {
        try{
            if(movieId<=0)
            {
                throw new Exception("Invalid ID");
            }

            movieService.deleteMovie(movieId);
            return ResponseEntity.ok("Movie deleted");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }    
}
