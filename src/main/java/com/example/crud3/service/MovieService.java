package com.example.crud3.service;

import com.example.crud3.entity.Movie;
import com.example.crud3.repository.MovieRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie findMovieById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id = " + id));
    }

    public List<Movie> findAllMovies(){
        return movieRepository.findAll();
    }

    public Movie updateMovie(Movie movie, Long id){
        return movieRepository.findById(id).map(entity -> {
            entity.setName(movie.getName());
            entity.setLength(movie.getLength());
            entity.setActors(movie.getActors());
            return movieRepository.save(entity);
        }).orElseThrow(() -> new EntityNotFoundException("Movie not found with id = " + id));
    }

    public void deleteMovieById(Long id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id = " + id));
        movieRepository.save(movie);
    }

    public void deleteAllMovies(){
        movieRepository.deleteAll();
    }
}
