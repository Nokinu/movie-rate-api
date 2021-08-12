package com.jzhang.movie.movierateapi.repositories;

import com.jzhang.movie.movierateapi.model.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

    @Tailable
    Flux<Movie> findMoviesByYear(String year);
}
