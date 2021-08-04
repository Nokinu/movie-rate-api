package com.jzhang.movie.movierateapi.service;

import com.jzhang.movie.movierateapi.model.User;
import com.jzhang.movie.movierateapi.repositories.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> findByUsername(String username) {
        return userRepository.findByName(username);
    }

    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }
}
