package com.example.crud3.controller;

import com.example.crud3.entity.Movie;
import com.example.crud3.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @PostMapping("/movies")
    public Movie saveMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    @GetMapping("/movies/{id}")
    public Movie findMovieById(@PathVariable Long id){
        return movieService.findMovieById(id);
    }

    @GetMapping("/movies")
    public List<Movie> findAllMovies(){
        return movieService.findAllMovies();
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovie(@RequestBody Movie movie,@PathVariable Long id){
        return movieService.updateMovie(movie, id);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
    }

    @DeleteMapping("/movies")
    public void deleteAllMovie(){
        movieService.deleteAllMovies();
    }
}
