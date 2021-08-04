package com.jzhang.movie.movierateapi.repositories;

import com.jzhang.movie.movierateapi.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Flux<User> findByName(String username);
}
