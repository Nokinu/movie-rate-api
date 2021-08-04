package com.jzhang.movie.movierateapi.service;

import com.jzhang.movie.movierateapi.model.Movie;
import com.jzhang.movie.movierateapi.repositories.MovieRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.management.ServiceNotFoundException;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public Mono<Void> deleteMovieById(String id) {
        return movieRepository.deleteById(id);
    }

    public Flux<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Mono<Movie> saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Mono<Movie> findOneById(String id) {
        return movieRepository.findById(id).switchIfEmpty(Mono.error(ServiceNotFoundException::new));
    }

    public Mono<Movie> updateMovieCastById(String cast, String id) {
        Mono<Movie> current = findOneById(id);
        return current.switchIfEmpty(Mono.error(ServiceNotFoundException::new))
                .map(movie -> {
                    movie.getCast().add(cast);
                    return movie;
                })
                .map(movie -> {
                    saveMovie(movie).subscribe();
                    return movie;
                });
    }

}
