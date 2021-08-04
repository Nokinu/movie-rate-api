package com.jzhang.movie.movierateapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Tomatoes {

    @JsonProperty("viewer")
    private Viewer viewer;
    @JsonProperty("lastUpdated")
    private Date lastUpdated;
}
