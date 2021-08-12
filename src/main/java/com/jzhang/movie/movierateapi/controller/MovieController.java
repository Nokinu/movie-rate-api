package com.jzhang.movie.movierateapi.controller;

import com.jzhang.movie.movierateapi.model.Movie;
import com.jzhang.movie.movierateapi.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Api(tags = "Movie APIs")
@RestController
@RequestMapping("/movies/v1/api")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ApiOperation(value = "Find all movies")
    @GetMapping
    public Flux<Movie> getAllMovies() {
        return movieService.findAllMovies();
    }

    @GetMapping(value = "/{year}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Movie> getAllMoviesByYear(@PathVariable("year") String year) {
        return movieService.findAllMoviesByYear(year).subscribeOn(Schedulers.boundedElastic());
    }

    @ApiOperation(value = "Find Movie by ID")
    @GetMapping("/{id}")
    public Mono<Movie> getMoviesById(@PathVariable("id") String id) {
       return movieService.findOneById(id);
    }

    @ApiOperation(value = "Add an new movie")
    @PostMapping("/new")
    public Mono<Movie> addNewMovie(@RequestParam("Movie") Movie movie) {
        return movieService.saveMovie(movie);
    }

    @ApiOperation(value = "Update Movie's cast by Id")
    @PutMapping("/{id}/cast")
    public Mono<Movie> updateMovieCastById(
            @PathVariable("id") @RequestParam("cast")
            String id, String cast) {
        return movieService.updateMovieCastById(cast, id);
    }

    @ApiOperation(value = "Delete a movie by Id")
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteMovieById(@PathVariable("id") String id) {
        return movieService.deleteMovieById(id);
    }
}
