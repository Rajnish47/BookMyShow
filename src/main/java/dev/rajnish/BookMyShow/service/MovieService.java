package dev.rajnish.BookMyShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.BookMyShow.model.Movie;
import dev.rajnish.BookMyShow.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(String name,String description)
    {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setDescription(description);

        return movieRepository.save(movie);
    }

    public Movie getMovie(int id)
    {
        return movieRepository.findById(id).get();
    }

    public Movie getMovie(String name)
    {
        return movieRepository.findMovieByName(name);
    }

    public void deleteMovie(int id)
    {
        movieRepository.deleteById(id);
    }    
}
