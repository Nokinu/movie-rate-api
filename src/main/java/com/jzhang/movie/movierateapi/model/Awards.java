package com.jzhang.movie.movierateapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Awards {

    @JsonProperty("wins")
    private Integer wins;
    @JsonProperty("nominations")
    private Integer nominations;
    @JsonProperty("text")
    private String text;
}
