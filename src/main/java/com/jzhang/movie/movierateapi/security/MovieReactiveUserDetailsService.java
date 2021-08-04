package com.jzhang.movie.movierateapi.security;

import com.jzhang.movie.movierateapi.service.UserService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MovieReactiveUserDetailsService implements ReactiveUserDetailsService {

    private final UserService userService;

    public MovieReactiveUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.from(userService.findByUsername(username))
                .switchIfEmpty(Mono.error(new UsernameNotFoundException("User Not Found")))
                .map(UserDetails.class::cast);
    }
}
