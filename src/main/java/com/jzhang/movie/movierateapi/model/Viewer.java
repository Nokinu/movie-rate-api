package com.jzhang.movie.movierateapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Viewer {

    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("numReviews")
    private Integer numReviews;
    @JsonProperty("meter")
    private Integer meter;
}
